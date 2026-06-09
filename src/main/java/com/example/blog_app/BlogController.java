package com.example.blog_app;

import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;



@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String getBlog() {
        return "blog";
    }

    @PostMapping("/blogs")
    public String newReport(@ModelAttribute BlogForm form, Model Model) {
        blogService.add(form);
        return "redirect:/blog";
    }
    
    @GetMapping("/blog/new")
    public String getNew() {
        return "blog/new";
    }

    @GetMapping("/blog")
    public String show() {
        return "blog";
    }

    @GetMapping("/blogs")
    public String getBlog(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blogs";
    }
    
    
    
}
