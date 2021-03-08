package blog.user.blogging.service;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.entity.Comments;
import blog.user.blogging.entity.Users;
import blog.user.blogging.repository.BlogsRepository;
import blog.user.blogging.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UsersService {
    @Autowired
    UsersRepository userRepo;

    @Autowired
    BlogsRepository blogRepo;

    @Transactional
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public Users getUserById(Long userId) {
        return userRepo.findById(userId).get();
    }

    @Transactional
    public String addUser(Users userDetail) {
        String userEmail = userDetail.getUserEmail();

        List<Users> user = userRepo.findByUserEmail(userEmail);

        if(!user.isEmpty())
            return "Your detail is already exist.";
        userRepo.save(userDetail);
        return "Your detail is successfully added.";
    }
}
