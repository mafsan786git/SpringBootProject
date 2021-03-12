package com.example.OneToMany.controller;

import com.example.OneToMany.entity.Review;
import com.example.OneToMany.repository.ReviewRepository;
import com.example.OneToMany.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @GetMapping("/review")
    public List<Review> getReview(){
        return reviewService.getReview();
    }
}
