package blog.user.blogging.controller;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.repository.BlogsRepository;
import blog.user.blogging.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogsController {

    @Autowired
    BlogsService blogServ;
    @GetMapping("/allblogs")
    public List<Blogs> getAllBlogs(){
        return blogServ.getAllBlogs();
    }
}
