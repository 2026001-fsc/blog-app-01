package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String startBlog() {
        return "redirect:/blogs";
    }

    @PostMapping("/blogs")
    public String newReport(@ModelAttribute BlogForm form, Model Model) {
        blogService.add(form);
        return "redirect:/blogs";
    }

    @GetMapping("/blog/new")
    public String getNew() {
        return "blog/new";
    }

    @GetMapping("/blogs")
    public String getBlog(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blog";
    }

    
    @GetMapping("/blogs/{id}")
    public String getBlogDetail(@PathVariable("id") Long id, Model model) {
        Optional<Blog> blog = blogService.findById(id); 
        model.addAttribute("blog", blog.get()); 
        return "blog/about"; 
    }
}
