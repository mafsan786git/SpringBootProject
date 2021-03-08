package blog.user.blogging.controller;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.repository.BlogsRepository;
import blog.user.blogging.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogsController {

    @Autowired
    BlogsService blogServ;

    @GetMapping("/blogs")
    public List<Blogs> getAllBlogs(){
        return blogServ.getAllBlogs();
    }

    @GetMapping("/blogbyid/{id}")
    public Blogs getBlogById(@PathVariable("id") Long blogId){
        return blogServ.getBlogById(blogId);
    }

    @PostMapping("/adduserblog/{id}")
    public String addUserBlog(@PathVariable("id") Long userId, @RequestBody Blogs blog){
        return blogServ.addUserBlog(userId,blog);
    }
}
