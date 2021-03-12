package blog.user.blogging.service;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Users;
import blog.user.blogging.repository.BlogsRepository;
import blog.user.blogging.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogsService {
    @Autowired
    BlogsRepository blogsRepository;

    @Autowired
    UsersRepository userRepo;

    @Transactional
    public List<Blogs> getAllBlogs() {
        return blogsRepository.findAll();
    }

//    @Transactional
//    public List<Blogs> getUserBlogs(Long userId) {
//        Optional<Users> userProfile = userRepo.findById(userId);
//        if(userProfile.isEmpty())
//            return new ArrayList<>();
//        System.out.println(userProfile.toString());
//        return userProfile.get().getBlogList();
//    }

//    public List<Comments> getUserComments(Long userId) {
//        Optional<Users> userProfile = userRepo.findById(userId);
//        if(userProfile.isEmpty())
//            return new ArrayList<>();
//        return userProfile.get().getCommentList();
//    }


    @Transactional
    public String addUserBlog(Long userId, Blogs blog) {
        Optional<Users> userProfile = userRepo.findById(userId);
        if (userProfile.isEmpty())
            return "user is not found";
        blog.setUsers(userProfile.get());
//        System.out.println(blog.toString());
        blogsRepository.save(blog);
        userProfile.get().setBlogList(blog);
        userRepo.save(userProfile.get());
        return "blog added successfully";
    }

    @Transactional
    public Blogs getBlogById(Long blogId) {
        Optional<Blogs> blog = blogsRepository.findById(blogId);
        if(blog.isEmpty())
            return null;
        System.out.println(blog.get().getUsers());
        return blog.get();
    }

    @Transactional
    public Users getUserOfBlog(Long blogId) {
        Optional<Blogs> blog = blogsRepository.findById(blogId);
        if(blog.isEmpty())
            return null;
        return blog.get().getUsers();
    }
}
