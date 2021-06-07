package com.booking.Assigment.service;

import com.booking.Assigment.dao.ReservationDAO;
import com.booking.Assigment.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService, Serializable {
    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public boolean addReservation(Reservation reservation) {

        if (reservationDAO.ReservationExists(reservation.getReservationCheckIn(),reservation.getRoom().getRoomId())) {
            return false;
        } else {
            reservationDAO.addReservation(reservation);
            return true;
        }
    }

}
