package pl.cms.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import pl.cms.post.Post;
import pl.cms.post.PostRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model) {
        List<Post> posts = postRepository.findAllByCategoryIdAndModeratedIsTrue(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "category";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

}
