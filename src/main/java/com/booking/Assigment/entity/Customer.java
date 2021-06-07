package com.booking.Assigment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

@Entity
@Table(name="customer")
public class Customer implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cus_id")
    private int customerId; 

	@NonNull
	@Column(name="cus_name")
    private String customerName;
	@Column(name="cus_gender")	
	private String customerGender;
	@Temporal(TemporalType.DATE)
	@Column(name="cus_dob")
    private Date customerDOB;
	@Column(name="cus_bio")	
	private String customerBio;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Review> reviews = new HashSet<Review>();
	
	public Customer() {
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerBio() {
		return customerBio;
	}
	public void setCustomerBio(String customerBio) {
		this.customerBio = customerBio;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
}