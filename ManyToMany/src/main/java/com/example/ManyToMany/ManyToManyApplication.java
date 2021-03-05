package com.example.ManyToMany;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import com.example.ManyToMany.repository.CourseRepository;
import com.example.ManyToMany.repository.StudentRepository;
import com.example.ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Autowired
	StudentService studentSer;

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CourseRepository courseRepo;

	@Override
	public void run(String... args) throws Exception {
		studentSer.insertCourse();
		Course c1 = new Course(1L,"science");
		Course c2 = new Course(2L,"math");
		Course c3 = new Course(3L,"operating system");
		this.courseRepo.save(c1);
		this.courseRepo.save(c2);
		this.courseRepo.save(c3);
//
		Student s1 = new Student(8L,"afsan");

		this.studentRepo.save(s1);

//
		c1.addStudent(s1);
		c2.addStudent(s1);
		c2.addStudent(s1);
//
//
		s1.addCourse(c1);
		s1.addCourse(c2);
		s1.addCourse(c3);
////
		this.studentRepo.save(s1);


	}
}
