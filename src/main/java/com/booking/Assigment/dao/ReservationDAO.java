package com.booking.Assigment.dao;

import com.booking.Assigment.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDAO {

    Reservation getReservationById(int reservation);

    void addReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservation(int reservationId);

    boolean ReservationExists(Date reservationCheckIn, int roomType);

    List<Reservation>getReservationByDate(Date date);

}
