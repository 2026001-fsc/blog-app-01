package com.example.blog_app;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    public void add(BlogForm form){
        if (form.getTitle() == null) {
            throw new IllegalArgumentException();
        }
        blogRepository.save(new Blog(null, form.getTitle(), form.getText()));
    }
}