package com.approve.com.approve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getReview(@PathVariable("id") String id){
        Review result = reviewService.getReviewById(id);
        if(result == null){
            return new Response("Review does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Review>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateReview(@PathVariable("id") String movieId, @RequestBody Review review){
        Review result = reviewService.getReviewById(review.getId());
        if(result == null){
            return new Response("Review does not exist", HttpStatus.NOT_FOUND);
        }
        reviewService.updateReview(review);
        return new Response("Review updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReview(@PathVariable("id") String id){
        Review result = reviewService.getReviewById(id);
        if(result == null){
            return new Response("Review does not exist", HttpStatus.NOT_FOUND);
        }
        reviewService.deleteReview(id);
        return new Response("Review deleted", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllReviews(){
        List<Review> result = reviewService.getAllReviews();
        return new ResponseEntity<List<Review>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/{movieId}/{reviewContent}/{userName}/{rating}", method = RequestMethod.GET)
    public ResponseEntity<?> addReview(@PathVariable("reviewContent") String reviewContent, @PathVariable("userName") String userName,
                    @PathVariable("movieId") String movieId, @PathVariable("rating") String rating){
        Review review = new Review();
        review.setMovieId(movieId);
        review.setReviewContent(reviewContent);
        review.setUserName(userName);
        review.setRating(Double.valueOf(rating.replace("p", ".")));
        reviewService.addReview(review);
        return new Response("System received the request. It will process as fast as possible.",
                HttpStatus.OK);
    }
}






