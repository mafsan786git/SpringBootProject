package com.example.OneToMany.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    private Long reviewId;
    private Long rating;
    private String description;
    /**Here don't need anything for Unidirectional*/
    /**This is for Bidirectional*/
    @ManyToOne
    @JsonBackReference
    Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Review(){}
    public Review(Long reviewId, Long rating, String description) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.description = description;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
