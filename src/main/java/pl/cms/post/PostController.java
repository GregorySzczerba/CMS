package pl.cms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.cms.category.Category;
import pl.cms.category.CategoryService;
import pl.cms.comment.Comment;
import pl.cms.comment.CommentRepository;
import pl.cms.user.User;
import pl.cms.user.UserRepository;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("post/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Post post = postRepository.findPostById(id);
        model.addAttribute("post", post);
        return "addpost";

    }

    @PostMapping("post/update/{id}")
    public String update(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/admin/adminaccount";
    }

    @GetMapping("admin/accept/{id}")
    public String accept(@PathVariable Long id) {
        Post post = postRepository.findPostById(id);
        post.setModerated(true);
        postRepository.save(post);
        return "redirect:/admin/adminaccount";
    }

    @GetMapping("admin/delete/{id}")
    public String delete(@PathVariable Long id) {
        Post post = postRepository.findPostById(id);
        postRepository.delete(post);
        return "redirect:/admin/adminaccount";
    }

    @GetMapping("/postpage/{id}")
    public String postpage(@PathVariable Long id, Model model) {
        Post post = postRepository.findPostById(id);
        model.addAttribute("comment", new Comment());

        model.addAttribute("post", post);
        return "postpage";
    }


    @PostMapping("comment")
    public String comment(@ModelAttribute @Valid Comment comment, Model model, BindingResult result) {
        Long id = comment.getPost().getId();
        model.addAttribute("id", id);

        if (result.hasErrors()) {
            return "redirect:postpage/{id}";
        }
        commentRepository.save(comment);
        return "redirect:postpage/{id}";
    }

    @GetMapping("/newpost")
    public String add(Model model, HttpSession httpSession, ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String email = request.getSession().getAttribute("email").toString();
        User user = userRepository.findUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/newpost")
    public String add(@ModelAttribute @Validated Post post, BindingResult result, HttpSession session, ServletRequest servletRequest, ServletResponse servletResponse)   {

        if (result.hasErrors()) {
            return "addpost";
        }
        postRepository.save(post);
        return "redirect:myaccount";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("comments")
    public List<Comment> getComments(Post post) {
        Long id = post.getId();
        return commentRepository.findAllByPostId(id);
    }

    /*@ModelAttribute("user")
    public User getUser(Model model, HttpSession session, ServletRequest servletRequest, ServletResponse servletResponse, User user) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if ()
        if (request.getSession().getAttribute("email") != null) {
            System.out.println("Nie ma takiego emaila");
            String email = request.getSession().getAttribute("email").toString();
            return userRepository.findUserByEmail(email);
        }
        return (new User );
         }
*/

}
