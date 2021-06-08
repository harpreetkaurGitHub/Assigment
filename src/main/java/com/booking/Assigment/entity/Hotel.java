package com.booking.Assigment.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

@Entity
@Table(name="hotel")
public class Hotel implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hot_id")
    private int hotelId; 
	
	@NonNull
	@Column(name="hot_name")
    private String hotelName;
	@Column(name="hot_email")	
	private String hotelEmail;
	@Column(name="hot_address")
    private String hotelAddress;
	@Column(name="hot_city")
	private String city;
	@Column(name="hot_rating")
	private int rating;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", orphanRemoval = true)
	@JsonIgnore
	private Set<Review> reviews = new HashSet<Review>();

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Amenity amenity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private List<Room> rooms = new LinkedList<>();

	public List<Room> getRooms() {
		return rooms;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel() {
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Amenity getAmenity() {
		return amenity;
	}

	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}

}
