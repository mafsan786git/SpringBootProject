package blog.user.blogging.service;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Users;
import blog.user.blogging.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository userRepo;

    @Transactional
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public List<Blogs> getUserBlogs(Long userId) {
        Optional<Users> userProfile = userRepo.findById(userId);
        if(userProfile.isEmpty())
            return new ArrayList<>();
        System.out.println(userProfile.toString());
        return userProfile.get().getBlogList();
    }

    @Transactional
    public Users getUserById(Long userId) {
        return userRepo.findById(userId).get();
    }
}
