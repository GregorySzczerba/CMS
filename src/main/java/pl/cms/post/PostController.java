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

    @GetMapping("admin/accept/{id}")
    public String accept(@PathVariable Long id) {
        Post post = postRepository.findPostById(id);
        post.setModerated(true);
        postRepository.save(post);
        return "redirect:/admin/adminaccount";
    }

    @GetMapping("/postpage/{id}")
    public String postpage(@PathVariable Long id, Model model) {
        Post post = postRepository.findPostById(id);
        model.addAttribute("comment", new Comment());

        model.addAttribute("post", post);
        return "postpage";
    }


    @PostMapping("/postpage/comment")
    public String comment(@ModelAttribute Comment comment) {
        commentRepository.save(comment);
        return "comment";
    }

    @GetMapping("/newpost")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/newpost")
    public String add(@ModelAttribute @Validated Post post, BindingResult result)   {
        if (result.hasErrors()) {
            return "addpost";
        }
        postRepository.save(post);
        return "redirect:myaccount";
    }

    /*@RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String submit(@RequestParam("image") MultipartFile image, ModelMap modelMap) {
        modelMap.addAttribute("image", image);
        return "picture";
    }*/

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("comments")
    public List<Comment> getComments(Post post) {
        Long id = post.getId();
        return commentRepository.findAllByPostId(id);
    }

    @ModelAttribute("user")
    public User getUser(HttpSession session, ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String email = request.getSession().getAttribute("email").toString();
        System.out.println(email);
        return userRepository.findUserByEmail(email);
    }


}
