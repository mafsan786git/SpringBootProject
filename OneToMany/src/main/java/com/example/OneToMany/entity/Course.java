package com.example.OneToMany.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Course {
    @Id
    private Long courseId;
    private  String courseName;

    /**This is for Unidirectional */
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reviewCourse_Id",referencedColumnName = "courseId")

    /**This is for Bidirectional*/
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Review> reviewList = new ArrayList<>();

    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    public List<Review> getReview() {
//        return reviewList;
//    }
    public void addReview(Review review) {
        this.reviewList.add(review);
    }
    public void removeReview(Review review){
        this.reviewList.remove(review);
    }
}
