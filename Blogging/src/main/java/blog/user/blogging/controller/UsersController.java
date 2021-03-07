package blog.user.blogging.controller;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Users;
import blog.user.blogging.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/user/{id}/blogs")
    public List<Blogs> getUserAllBlogs(@PathVariable("id") Long userId){
        return userServ.getUserBlogs(userId);
    }

}
