package com.booking.Assigment.service;

import java.util.List;

import com.booking.Assigment.entity.Hotel;
import com.booking.Assigment.entity.Search;

public interface HotelService {

	Hotel getHotelById(int hotelId);

	List<Hotel> searchHotels(Search search);

	boolean addHotel(Hotel hotel);

	void updateHotel(Hotel hotel);


}
