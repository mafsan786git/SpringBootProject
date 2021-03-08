package blog.user.blogging.controller;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Comments;
import blog.user.blogging.entity.Users;
import blog.user.blogging.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService userServ;

    @GetMapping("/allusers")
    public List<Users> getAllUsers(){
        return userServ.getAllUsers();
    }

    @GetMapping("/userbyid/{id}")
    public Users getUserById(@PathVariable("id") Long userId)
    {
        return userServ.getUserById(userId);
    }

    @GetMapping("/userblogs/{id}")
    public List<Blogs> getUserBlogs(@PathVariable("id") Long userId){
        return userServ.getUserBlogs(userId);
    }
    @GetMapping("/usercomments/{id}")
    public List<Comments> getUserComments(@PathVariable("id") Long userId){
        return userServ.getUserComments(userId);
    }

    @PostMapping("/user/{id}/blog")
    public Blogs addUserBlog(@PathVariable("id") Long userId, @RequestBody Blogs blog){
        return userServ.addUserBlog(userId,blog);
    }

}
