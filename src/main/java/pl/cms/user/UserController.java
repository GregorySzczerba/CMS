package pl.cms.user;

import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.cms.post.Post;
import pl.cms.post.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/myaccount")
    public String myaccount(Model model, HttpSession httpSession,
                            HttpServletRequest servletRequest, HttpServletResponse httpServletResponse) {
        String email =  servletRequest.getSession().getAttribute("email").toString();
        List<Post> postList = postRepository.findAllByUserEmailAndModeratedIsTrue(email);
        model.addAttribute("postList", postList);
        User user = userRepository.findUserByEmail(email);
        model.addAttribute("user", user);
        userRepository.save(user);

        return "myaccount";
    }

    @PostMapping("/myaccount")
    public String account() {
        return "myaccount";
    }

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

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        User user = userRepository.findUserById(id);
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/update/{id}")
    public String updateUser(HttpSession session, @ModelAttribute @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
        String email = user.getEmail();
        session.setAttribute("email", email);
        return "redirect:../myaccount";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession httpSession) {
        boolean isLogged = false;
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            model.addAttribute("isLogged", isLogged);
            return "login";
        }
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            isLogged = BCrypt.checkpw(password, user.getPassword());
            httpSession.setAttribute("email", email);
        }
        if (isLogged) {
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("isLogged", isLogged);
            return "redirect:myaccount";
        }
        model.addAttribute("isLogged", isLogged);
        return "login";
    }

    @GetMapping("/admin/login")
    public String loginAdmin() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpSession httpSession) {
        boolean isLoggedAdmin = false;
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            model.addAttribute("isLoggedAdmin", isLoggedAdmin);
            return "admin/login";
        }
        User user = userRepository.findUserByEmailAndAdminIsTrue(email);
        if (user != null) {
            isLoggedAdmin = BCrypt.checkpw(password, user.getPassword());
            httpSession.setAttribute("email", email);
        } else if (user == null) {
            return "admin/login";
        }
        if (isLoggedAdmin) {
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("isLoggedAdmin", isLoggedAdmin);
            return "redirect:/..myaccount";
        }
        model.addAttribute("isLoggedAdmin", isLoggedAdmin);
        return "admin/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("isLogged", null);
        session.setAttribute("email", null);
        return "redirect:/";
    }

    @GetMapping("admin/logout")
    public String logoutAdmin(HttpSession session) {
        session.setAttribute("isLoggedAdmin", null);
        session.setAttribute("email", null);
        return "redirect:/";
    }

   /* @GetMapping("/myaccount")
    public String myaccount(@PathVariable User user, Model model) {
        List<Post> postList = postRepository.findAllByUserId(user.getId());
        model.addAttribute("postList", postList);
        return "myaccount";
    }*/
}
