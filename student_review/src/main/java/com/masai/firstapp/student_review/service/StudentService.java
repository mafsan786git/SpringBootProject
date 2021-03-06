package com.masai.firstapp.student_review.service;

import com.masai.firstapp.student_review.entity.Student;
import com.masai.firstapp.student_review.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepo;
    //Get all data into student
    public List<Student> getAllStudents() {
        List<Student> student1 = studentrepo.findAll();
        return student1;
    }

    //add student data
	public Student addStudent(Student student) {
        Student student1 = studentrepo.save(student);
        return student1;
	}

    //update student
	public String updateStudent(Student student) {
        Optional<Student> student1 = studentrepo.findById(student.getStudentId());

        if(student1.isEmpty())
            return "Repository Error";

        //update info
        student1.get().setStudentName(student.getStudentName());
        student1.get().setStudentSection(student.getStudentSection());

        //save info into database;
        studentrepo.save(student1.get());
		return "Info updated";
	}

	public String deleteStudent(String studentId) {
        Student student1 = studentrepo.findById(studentId).get();

        try {
            studentrepo.delete(student1);
            return "Successfully Deleted";
        } catch (Exception e) {
            return "Delete Failed";
        }
	}
}
