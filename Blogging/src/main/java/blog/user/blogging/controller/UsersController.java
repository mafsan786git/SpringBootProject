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

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userServ.getAllUsers();
    }

    @GetMapping("/userid/{id}")
    public Users getUserById(@PathVariable("id") Long userId) {
        return userServ.getUserById(userId);
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody Users userDetail){
        System.out.println(userDetail.toString());
        return userServ.addUser(userDetail);
    }

}
