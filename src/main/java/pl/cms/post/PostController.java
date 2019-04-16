package pl.cms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.cms.category.Category;
import pl.cms.category.CategoryService;

import javax.xml.ws.Service;
import java.awt.print.Book;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/postpage/{id}")
    public String postpage(@PathVariable Long id, Model model) {
        Post post = postRepository.findPostById(id);
        model.addAttribute("post", post);
        return "postpage";

    }

    @GetMapping("/addpost")
    public String addpost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }

   /* @PostMapping("/addpost")
    public String add(@ModelAttribute Post post) {
        postService.save(post);
        return "addpost";
    }*/

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String submit(@RequestParam("image") MultipartFile image, ModelMap modelMap) {
        modelMap.addAttribute("image", image);
        return "picture";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }


}
