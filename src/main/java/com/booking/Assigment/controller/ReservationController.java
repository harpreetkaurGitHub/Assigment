package com.booking.Assigment.controller;

import com.booking.Assigment.entity.Reservation;
import com.booking.Assigment.service.ReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@Controller
@RequestMapping("booking")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("reservation")
    public ResponseEntity<Void> addReservation(@RequestBody Reservation reservation, UriComponentsBuilder builder) {

        boolean flag = reservationService.addReservation(reservation);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customer/{id}").buildAndExpand(reservation.getReservationId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
