package com.booking.Assigment.dao;

import java.util.List;

import com.booking.Assigment.entity.Customer;
import com.booking.Assigment.entity.Hotel;
import com.booking.Assigment.entity.Review;


public interface ReviewDAO {

	Review getReviewById(int reviewId);

	List<Review> getAllReviews();

	void addReview(Review review);

	void updateReview(Review review);

	void deleteReview(int reviewId);

	boolean ReviewExists(Customer customer, Hotel hotel);

}
