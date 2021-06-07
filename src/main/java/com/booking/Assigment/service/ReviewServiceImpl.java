package com.booking.Assigment.service;

import java.util.List;

import com.booking.Assigment.dao.ReviewDAO;
import com.booking.Assigment.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDAO reviewDAO;
	@Override
	public Review getReviewById(int reviewId) {
		Review obj = reviewDAO.getReviewById(reviewId);
		return obj;
	}	
	@Override
	public List<Review> getAllReviews(){
		return reviewDAO.getAllReviews();
	}
	@Override
	public synchronized boolean addReview(Review review){
       if (reviewDAO.ReviewExists(review.getCustomer(), review.getHotel())) {
    	   return false;
       } else {
    	   reviewDAO.addReview(review);
    	   return true;
       }
	}
	@Override
	public void updateReview(Review review) {
		reviewDAO.updateReview(review);
	}
	@Override
	public void deleteReview(int reviewId) {
		reviewDAO.deleteReview(reviewId);
	}
}