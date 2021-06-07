package com.booking.Assigment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.booking.Assigment.entity.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class HotelDAOImpl implements HotelDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Hotel getHotelById(int hotelId) {
		return entityManager.find(Hotel.class, hotelId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getAllHotels() {
		String hql = "FROM Hotel as cust ORDER BY cust.hotelId";
		return (List<Hotel>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addHotel(Hotel hotel) {
		entityManager.persist(hotel);
	}
	@Override
	public void updateHotel(Hotel hotel) {
		Hotel cust = getHotelById(hotel.getHotelId());
		cust.setHotelName(hotel.getHotelName());
		cust.setHotelEmail(hotel.getHotelEmail());
		cust.setHotelAddress(hotel.getHotelAddress());
		entityManager.flush();
	}
	@Override
	public void deleteHotel(int hotelId) {
		entityManager.remove(getHotelById(hotelId));
	}

	@Override
	public boolean roomExist(int roomId) {
		String hql = "FROM Reservation as hot WHERE hot.roomId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, roomId)
				.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public List<Hotel> searchHotelByCity(String city) {
		String hql = "FROM Hotel as hot WHERE hot.city = ?1";
		return (List<Hotel>) entityManager.createQuery(hql).setParameter(1,city).getResultList();
	}

	@Override
	public boolean HotelExists(String hotelName) {
		String hql = "FROM Hotel as hot WHERE hot.hotelName = ?1";
		int count = entityManager.createQuery(hql).setParameter(1, hotelName)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
