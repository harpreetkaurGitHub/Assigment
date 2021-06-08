package com.booking.Assigment.service;

import java.util.List;
import java.util.Map;

import com.booking.Assigment.entity.Customer;

public interface CustomerService {

	Customer getCustomerById(int customerId);

	List<Customer> getAllCustomers();

	boolean addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	Map<String,Object> getCustomerDetail(String name);

}
