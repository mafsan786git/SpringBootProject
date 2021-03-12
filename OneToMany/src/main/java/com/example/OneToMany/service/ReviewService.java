package com.example.OneToMany.service;

import com.example.OneToMany.entity.Review;
import com.example.OneToMany.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepo;
    public List<Review> getReview() {
        return reviewRepo.findAll();
    }
}
