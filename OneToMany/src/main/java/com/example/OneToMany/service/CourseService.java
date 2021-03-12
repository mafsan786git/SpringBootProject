package com.example.OneToMany.service;

import com.example.OneToMany.entity.Course;
import com.example.OneToMany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepo;
    public List<Course> getAllCourse(){
        return courseRepo.findAll();
    }
}
