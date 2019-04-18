package pl.cms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cms.category.Category;
import pl.cms.category.CategoryService;
import pl.cms.comment.Comment;
import pl.cms.comment.CommentRepository;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentRepository commentRepository;

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

    @GetMapping("/addpost")
    public String addpost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/addpost")
    public String add(@ModelAttribute Post post) {
        postRepository.save(post);
        return "addpost";
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


}
