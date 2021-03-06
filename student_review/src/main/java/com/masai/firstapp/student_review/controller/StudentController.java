package com.masai.firstapp.student_review.controller;

import com.masai.firstapp.student_review.entity.Student;
import com.masai.firstapp.student_review.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> studentInfo = studentService.getAllStudents();
        return  studentInfo;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        return student1;
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student )
    {
        String student1 = studentService.updateStudent(student);
        return student1;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") String studentId){
        String student1 = studentService.deleteStudent(studentId);
        return student1;
    }

}
