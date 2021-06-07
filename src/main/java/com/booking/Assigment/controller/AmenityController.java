package com.booking.Assigment.controller;

import java.util.List;

import com.booking.Assigment.entity.Amenity;
import com.booking.Assigment.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("booking")
public class AmenityController {
	@Autowired
	private AmenityService AmenityService;

	@PostMapping("amenity")
	public ResponseEntity<Void> addAmenity(@RequestBody Amenity amenity, UriComponentsBuilder builder) {
        boolean flag = AmenityService.addAmenity(amenity);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/amenity/{id}").buildAndExpand(amenity.getAmenityId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("amenity")
	public ResponseEntity<Amenity> updateAmenity(@RequestBody Amenity amenity) {
		AmenityService.updateAmenity(amenity);
		return new ResponseEntity<Amenity>(amenity, HttpStatus.OK);
	}
} 