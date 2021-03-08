package blog.user.blogging.service;

import blog.user.blogging.entity.Blogs;
import blog.user.blogging.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogsService {
    @Autowired
    BlogsRepository blogsRepository;
    @Transactional
    public List<Blogs> getAllBlogs() {
        return blogsRepository.findAll();
    }
}
