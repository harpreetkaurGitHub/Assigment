package com.booking.Assigment.controller;

import java.util.List;

import com.booking.Assigment.entity.Review;
import com.booking.Assigment.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("booking")
public class ReviewController {
	@Autowired
	private com.booking.Assigment.service.ReviewService ReviewService;
	@GetMapping("review/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable("id") Integer id) {
		Review review = ReviewService.getReviewById(id);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	@GetMapping("reviews")
	public ResponseEntity<List<Review>> getAllReviews() {
		List<Review> list = ReviewService.getAllReviews();
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	@PostMapping("review")
	public ResponseEntity<Void> addReview(@RequestBody Review review, UriComponentsBuilder builder) {
		boolean flag = ReviewService.addReview(review);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/review/{id}").buildAndExpand(review.getReviewId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("review")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) {
		ReviewService.updateReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	@DeleteMapping("review/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable("id") Integer id) {
		ReviewService.deleteReview(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 