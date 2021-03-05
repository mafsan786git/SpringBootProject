package com.example.ManyToMany.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    private Long courseId;
    private String courseName;

    @ManyToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> studentList = new ArrayList<>();

    public Course(Long courseId,String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void removeStudent(Student student){
        this.studentList.remove(student);
    }
}
