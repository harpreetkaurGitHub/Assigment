package com.booking.Assigment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.booking.Assigment.dao.CustomerDAO;
import com.booking.Assigment.entity.Customer;
import com.booking.Assigment.entity.Hotel;
import com.booking.Assigment.entity.Reservation;
import com.booking.Assigment.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}	
	@Override
	public List<Customer> getAllCustomers(){
		return customerDAO.getAllCustomers();
	}
	@Override
	public synchronized boolean addCustomer(Customer customer){
       if (customerDAO.CustomerExists(customer.getCustomerName(), customer.getCustomerGender())) {
    	   return false;
       } else {
    	   customerDAO.addCustomer(customer);
    	   return true;
       }
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}

	@Override
	public Map<String, Object> getCustomerDetail(String name) {
		Customer customer = customerDAO.getCustomerByName(name);
		Reservation reservation = customer.getReservation();
		Room room = reservation.getRoom();
		Hotel hotel = room.getHotel();

		Map<String,Object> customerDetails = new HashMap<>();
		customerDetails.put("Name",customer.getCustomerName());
		customerDetails.put("CheckIn",reservation.getReservationCheckIn());
		customerDetails.put("RoomType",room.getRoomType());
		customerDetails.put("Price",room.getRoomPrice());
		customerDetails.put("HotelName",hotel.getHotelName());

		return customerDetails;
	}
}