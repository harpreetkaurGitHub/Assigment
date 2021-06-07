package com.booking.Assigment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="res_id")
    private int reservationId;

	@Temporal(TemporalType.DATE)
	@Column(name="res_date")
    private Date reservationDate;
	@Temporal(TemporalType.DATE)
	@Column(name="res_checkin")
    private Date reservationCheckIn;
	@Temporal(TemporalType.DATE)
	@Column(name="res_checkout")
    private Date reservationCheckOut;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cus_id", nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Customer customer;

	@OneToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="roo_id", referencedColumnName="roo_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
    private Room room;


	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getReservationCheckIn() {
		return reservationCheckIn;
	}

	public void setReservationCheckIn(Date reservationCheckIn) {
		this.reservationCheckIn = reservationCheckIn;
	}

	public Date getReservationCheckOut() {
		return reservationCheckOut;
	}

	public void setReservationCheckOut(Date reservationCheckOut) {
		this.reservationCheckOut = reservationCheckOut;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
