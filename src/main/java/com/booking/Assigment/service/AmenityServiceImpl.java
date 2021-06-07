package com.booking.Assigment.service;

import java.util.List;

import com.booking.Assigment.dao.AmenityDAO;
import com.booking.Assigment.entity.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AmenityServiceImpl implements AmenityService {
	@Autowired
	private AmenityDAO amenityDAO;

	@Override
	public synchronized boolean addAmenity(Amenity amenity){
       if (amenityDAO.AmenityExists(amenity.getAmenityId())) {
    	   return false;
       } else {
    	   amenityDAO.addAmenity(amenity);
    	   return true;
       }
	}
	@Override
	public void updateAmenity(Amenity amenity) {
		amenityDAO.updateAmenity(amenity);
	}
}