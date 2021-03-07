package blog.user.blogging;

import blog.user.blogging.entity.Users;
import blog.user.blogging.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class BloggingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);
	}

	@Autowired
	UsersService userServ;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		List<Users> userList = userServ.getAllUsers();
//		for(Users user : userList){
//			System.out.println(user.toString());
//		}
		System.out.println(userServ.getUserBlogs(2L));
		System.out.println("command Line runner");
	}
}
