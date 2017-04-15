package com.polytech.view;

import com.polytech.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.security.Principal;
import java.util.List;

/**
 * Created by KHOA on 15-Mar-17.
 */
@Controller
public class PostController {

    @Autowired
    private PublicationService publicationService;



    @RequestMapping(value = "/feed",method = RequestMethod.GET)
    public String home(Model model){
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        return "feed";
    }

    @RequestMapping(value="/post",method = RequestMethod.POST)
    public String post(Post post, Model model, Principal principal){
        String username = principal.getName();
        User user = new User();
        user.setUsername(username);
        post.setUser(user);
        publicationService.post(post);
        return "redirect:/feed";
    }

}
