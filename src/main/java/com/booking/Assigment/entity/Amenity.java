package com.booking.Assigment.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

@Entity
@Table(name="amenity")
public class Amenity implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="hot_id")
    private int amenityId;
	@Column(name="ame_restaurant")
    private Boolean amenityRestaurant;
	@Column(name="ame_wifi")
    private Boolean amenityWifi;
	@Column(name="ame_ac")
    private Boolean amenityAirconditioning;
	@Column(name="ame_breakfast")
    private Boolean amenityBreakfast;
	@Column(name="ame_pool")
    private Boolean amenityPool;
	@Column(name="ame_gym")
    private Boolean amenityGym;
	
	@OneToOne(mappedBy="amenity", cascade=CascadeType.ALL)
	@JsonIgnore
	private Hotel hotel;
	
	public int getAmenityId() {
		return amenityId;
	}

	public Boolean getAmenityRestaurant() { return amenityRestaurant; }
	public void setAmenityRestaurant(Boolean amenityRestaurant) {
		this.amenityRestaurant = amenityRestaurant;
	}
	public Boolean getAmenityWifi() {
		return amenityWifi;
	}
	public void setAmenityWifi(Boolean amenityWifi) {
		this.amenityWifi = amenityWifi;
	}
	public Boolean getAmenityAirconditioning() {
		return amenityAirconditioning;
	}
	public void setAmenityAirconditioning(Boolean amenityAirconditioning) { this.amenityAirconditioning = amenityAirconditioning; }
	public Boolean getAmenityBreakfast() {
		return amenityBreakfast;
	}
	public void setAmenityBreakfast(Boolean amenityBreakfast) {
		this.amenityBreakfast = amenityBreakfast;
	}
	public Boolean getAmenityPool() {
		return amenityPool;
	}
	public void setAmenityPool(Boolean amenityPool) {
		this.amenityPool = amenityPool;
	}
	public Boolean getAmenityGym() {
		return amenityGym;
	}
	public void setAmenityGym(Boolean amenityGym) {
		this.amenityGym = amenityGym;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
