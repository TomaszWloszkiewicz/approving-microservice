package com.approve.com.approve;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import com.approve.com.approve.Review;
import com.approve.com.approve.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
        this.reviewRepository.deleteAll();
    }

    @Async
    public void addReview(Review review){
        try {
            //Someone has to accept the review.. please wait a minute
            Thread.sleep(60000);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Review>> violations = validator.validate(review);
            if(violations.size()>0){
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reviewRepository.save(review);
    }

    public Review getReviewById(String id){
        return reviewRepository.findById(id);
    }

    public boolean updateReview(Review review, String id){
        Review review1 = reviewRepository.findById(id);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Review>> violations = validator.validate(review1);
        if(violations.size()>0 || review1 == null){
            return false;
        }
        reviewRepository.save(review);
        return true;
    }

    public void deleteReview(String id){
        reviewRepository.delete(id);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
}