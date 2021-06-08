package com.booking.Assigment.controller;

import java.util.List;
import java.util.Map;

import com.booking.Assigment.entity.Customer;
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
public class CustomerController {
	@Autowired
	private com.booking.Assigment.service.CustomerService CustomerService;
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Customer customer = CustomerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = CustomerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	@PostMapping("customer")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
        boolean flag = CustomerService.addCustomer(customer);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customer/{id}").buildAndExpand(customer.getCustomerId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		CustomerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
		CustomerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("customerDetail/{name}")
	public ResponseEntity<Map<String,Object>> getCustomerDetail(@PathVariable String name){
		Map<String,Object> map = CustomerService.getCustomerDetail(name);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
} 