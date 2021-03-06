package com.example.ManyToMany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    private Long studentId;
    private String studentName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id"))
    private List<Course> courseList = new ArrayList<>();


    public Student(Long studentId,String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void addCourse(Course course){
        this.courseList.add(course);
    }

    public void removeCourse(Course course){
        this.courseList.remove(course);
    }


}
