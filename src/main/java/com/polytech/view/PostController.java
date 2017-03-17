package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by KHOA on 15-Mar-17.
 */
@Controller
public class PostController {

    private PublicationService publicationService;

    @Autowired
    public PostController(PublicationService publicationService){
        this.publicationService = publicationService;
    }

    @RequestMapping(value = "/feed",method = RequestMethod.GET)
    public String home(Model model){
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        return "feed";
    }

    @RequestMapping(value="/post",method = RequestMethod.POST)
    public String post(Post post, Model model, Principal principal){
        String username = principal.getName();
        publicationService.post(post);
        return "redirect:/feed";

    }
}
