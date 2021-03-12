package com.example.OneToMany.controller;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.entity.Review;
import com.example.OneToMany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseServ;
    @GetMapping("/allcourse")
    public List<Course> allCourse(){
        return courseServ.getAllCourse();
    }


}
