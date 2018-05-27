package com.approve.com.approve;

import com.approve.com.approve.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String>{
    Review findById(String id);

}


