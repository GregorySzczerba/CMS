package pl.cms.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

 /*   @Autowired
    private CommentRepository commentRepository;

   *//* @GetMapping("comment/postpage/{id}")
    public String commentGet() {
        return "redirect:/../";
    }*//*

    @PostMapping("/comment")
    public String comment(Comment comment) {
        commentRepository.save(comment);
        return "redirect:/../";

    }*/
}
