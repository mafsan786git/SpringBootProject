package blog.user.blogging.service;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Comments;
import blog.user.blogging.entity.Users;
import blog.user.blogging.repository.BlogsRepository;
import blog.user.blogging.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    BlogsRepository blogRepo;

    @Autowired
    BlogsService blogServ;

    @Autowired
    UsersService userServ;

    @Autowired
    CommentsRepository commentRepo;
    @Transactional
    public List<Comments> getCommentByBlogId(Long blogId) {
        Blogs blog = blogServ.getBlogById(blogId);
        if(blog == null)
            return new ArrayList<>();
        return blog.getCommentList();
    }

    @Transactional
    public String addCommentByBlogId(Long userId,Long blogId, Comments comment) {
        Blogs blog = blogServ.getBlogById(blogId);
        if(blog == null)
            return "Blog does not exist.";
        Users user = userServ.getUserById(userId);
        if(user == null)
            return "user does not exist";
        comment.setUsers(user);
        comment.setBlogs(blog);
        commentRepo.save(comment);
        blog.setCommentList(comment);
        user.setCommentList(comment);
        return "added successfully";
    }

    @Transactional
    public List<Comments> getAllComment() {
        return commentRepo.findAll();
    }
}
