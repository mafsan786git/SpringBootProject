package blog.user.blogging.controller;


import blog.user.blogging.entity.Comments;
import blog.user.blogging.repository.CommentsRepository;
import blog.user.blogging.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {
    @Autowired
    CommentsService commentServ;
    @GetMapping("/comment/{blogId}/blog")
    public List<Comments> getAllCommentsOfBlogId(@PathVariable("blogId") Long blogId){
        return commentServ.getCommentByBlogId(blogId);
    }

    @PostMapping("/addcomment/{blogId}/{userId}")
    public String addCommentByBlogId(@PathVariable("blogId") Long blogId,
                                     @PathVariable("userId") Long userId,
                                     @RequestBody Comments comment){
        System.out.println(".............inside addcomment......................");
        return commentServ.addCommentByBlogId(userId,blogId,comment);
    }

    @GetMapping("/comment")
    public List<Comments> getAllComment(){
        return commentServ.getAllComment();
    }
}
