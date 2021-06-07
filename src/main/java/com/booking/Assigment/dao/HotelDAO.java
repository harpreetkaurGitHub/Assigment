package com.booking.Assigment.dao;

import java.util.List;

import com.booking.Assigment.entity.Hotel;

public interface HotelDAO {

	Hotel getHotelById(int hotelId);

	List<Hotel> getAllHotels();

	void addHotel(Hotel hotel);

	void updateHotel(Hotel hotel);

	void deleteHotel(int hotelId);

	boolean HotelExists(String hotelName);

	boolean roomExist(int roomId);

	List<Hotel> searchHotelByCity(String city);

}
