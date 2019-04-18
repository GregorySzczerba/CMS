package pl.cms.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.cms.post.Post;
import pl.cms.post.PostRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model) {
        List<Post> posts = postRepository.findAllByCategoryIdAndModeratedIsTrue(id);
        model.addAttribute("posts", posts);
        return "category";
    }
}
