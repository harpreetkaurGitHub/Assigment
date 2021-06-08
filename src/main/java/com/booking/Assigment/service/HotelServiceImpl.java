package com.booking.Assigment.service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import com.booking.Assigment.dao.HotelDAO;
import com.booking.Assigment.dao.ReservationDAO;
import com.booking.Assigment.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDAO hotelDAO;

	@Autowired
	ReservationDAO reservationDAO;

	@Override
	public Hotel getHotelById(int hotelId) {
		Hotel obj = hotelDAO.getHotelById(hotelId);
		return obj;
	}	
	@Override
	public List<Hotel> searchHotels(Search search) {
		List<Hotel> hotelList = hotelDAO.getAllHotels();
		return getSearchedHotels(search,hotelList);
	}
	@Override
	public synchronized boolean addHotel(Hotel hotel){
       if (hotelDAO.HotelExists(hotel.getHotelName())) {
    	   return false;
       } else {
    	   hotelDAO.addHotel(hotel);
    	   return true;
       }
	}
	@Override
	public void updateHotel(Hotel hotel) {
		hotelDAO.updateHotel(hotel);
	}

	private List<Hotel>getSearchedHotels(Search search,List<Hotel>hotelList){
		try {
			if (Objects.nonNull(search.getCity())) {
				hotelList = hotelDAO.searchHotelByCity(search.getCity());
			}
			if (Objects.nonNull(search.getDate())) {
				List<Reservation> reservationList = reservationDAO.getReservationByDate(search.getDate());
				for (Hotel hotel : hotelList) {
					for (Reservation reservation : reservationList) {
						if (hotel.getRooms().contains(reservation.getRoom())) {
							hotel.getRooms().remove(reservation.getRoom());
						}
					}
				}
			}
			if (search.isWifi()) {
				for (Iterator<Hotel> iterator = hotelList.iterator(); iterator.hasNext();) {
					Hotel hotel = iterator.next();
					if(!hotel.getAmenity().getAmenityWifi().equals(search.isWifi())) {
						iterator.remove();
					}
				}
			}
			if (search.isRestaurant()){
				for (Iterator<Hotel> iterator = hotelList.iterator(); iterator.hasNext();) {
					Hotel hotel = iterator.next();
					if(!hotel.getAmenity().getAmenityRestaurant().equals(search.isRestaurant())) {
						iterator.remove();
					}
				}
			}
			if (search.isAirCondition()){
				for (Iterator<Hotel> iterator = hotelList.iterator(); iterator.hasNext();) {
					Hotel hotel = iterator.next();
					if(!hotel.getAmenity().getAmenityAirconditioning().equals(search.isAirCondition())) {
						iterator.remove();
					}
				}
			}
			if (search.isBreakfast()){
				for (Iterator<Hotel> iterator = hotelList.iterator(); iterator.hasNext();) {
					Hotel hotel = iterator.next();
					if(!hotel.getAmenity().getAmenityBreakfast().equals(search.isBreakfast())) {
						iterator.remove();
					}
				}
			}

		}
		catch (Exception e){
			e.printStackTrace();
		}
		return hotelList;
	}
}