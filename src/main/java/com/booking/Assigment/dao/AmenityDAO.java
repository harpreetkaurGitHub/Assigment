package com.booking.Assigment.dao;

import java.util.List;

import com.booking.Assigment.entity.Amenity;

public interface AmenityDAO {

	Amenity getAmenityById(int amenityId);

	void addAmenity(Amenity amenity);

	void updateAmenity(Amenity amenity);

	boolean AmenityExists(int hotelId);

}
