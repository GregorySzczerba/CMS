package pl.cms.user;

import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cms.post.Post;
import pl.cms.post.PostRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String add(@ModelAttribute @Valid  User user,  BindingResult result,  Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userService.save(user);
        model.addAttribute("user", user);
        return "myaccount";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isLogged = false;
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            model.addAttribute("isLogged", isLogged);
            return "login";
        }
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            isLogged = BCrypt.checkpw(password, user.getPassword());
        }
        if (isLogged) {
            model.addAttribute("user", user);
            return "myaccount";
        }
        model.addAttribute("isLogged", isLogged);
        return "login";
    }

   /* @GetMapping("/myaccount")
    public String myaccount(@PathVariable User user, Model model) {
        List<Post> postList = postRepository.findAllByUserId(user.getId());
        model.addAttribute("postList", postList);
        return "myaccount";
    }*/
}
