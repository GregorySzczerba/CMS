package pl.cms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.cms.category.Category;
import pl.cms.category.CategoryService;

import javax.xml.ws.Service;
import java.awt.print.Book;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/addpost")
    public String addpost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/addpost")
    public String add(@ModelAttribute Post post) {
        postService.save(post);
        return "addpost";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }
}
