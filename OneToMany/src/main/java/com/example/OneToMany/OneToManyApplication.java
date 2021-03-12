package com.example.OneToMany;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Review;
import com.example.OneToMany.repository.CourseRepository;
import com.example.OneToMany.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Course c = new Course(123L,"Maths");
		Review r1 = new Review(78L,4L,"very good subject as math",c);
		Review r2 = new Review(79L,5L,"very good subject interesting",c);
		Review r3 = new Review(80L,6L,"very good subject",c);

		c.addReview(r1);
		c.addReview(r2);
		c.addReview(r3);

		this.courseRepo.save(c);
//
//		r1.setCourse(c);
////		c.addReview(r1);
		this.reviewRepo.save(r1);
//
//		r2.setCourse(c);
////		c.addReview(r2);
		this.reviewRepo.save(r2);
//
//		r3.setCourse(c);
////		c.addReview(r3);
		this.reviewRepo.save(r3);

	}


}
