package com.polytech.view;

import com.polytech.business.Comment;
import com.polytech.business.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by KHOA on 13-Apr-17.
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/comment/{id}",method = RequestMethod.GET)
    public String listComment(Model model, @PathVariable("id") Long id){
        model.addAttribute("comments",commentService.fetchAll(id));
        return "commentResult :: commentList";
    }

    @RequestMapping(value="/write/{id}/{content}")
    public String writeComment(Model model, @PathVariable("id") Long id,@PathVariable("content") String content){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        commentService.comment(content, user.getUsername(), id);
        model.addAttribute("comments",commentService.fetchAll(id));
        return "commentResult :: commentList";
    }
}
