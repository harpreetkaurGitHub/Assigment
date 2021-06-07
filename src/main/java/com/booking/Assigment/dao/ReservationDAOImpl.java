package com.booking.Assigment.dao;

import com.booking.Assigment.entity.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;



@Transactional
@Repository
public class ReservationDAOImpl implements  ReservationDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reservation getReservationById(int reservation) {
        return entityManager.find(Reservation.class,reservation);
    }

    @Override
    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Reservation cust = getReservationById(reservation.getReservationId());
        cust.setCustomer(reservation.getCustomer());
        cust.setReservationDate(reservation.getReservationDate());
        cust.setReservationCheckOut(reservation.getReservationCheckOut());
        cust.setRoom(reservation.getRoom());

        entityManager.flush();
    }
    @Override
    public void deleteReservation(int reservationId) {
        entityManager.remove(getReservationById(reservationId));
    }

    public boolean ReservationExists(Date reservationCheckIn, int roomId) {
        String hql = "FROM Reservation as cust WHERE cust.reservationCheckIn =?0";
        int count = entityManager.createQuery(hql).setParameter(0, reservationCheckIn).getResultList().size();
        return count > 0 ? true : false;
    }

    @Override
    public List<Reservation> getReservationByDate(Date reservationCheckIn) {
        String hql = "FROM Reservation as cust WHERE cust.reservationCheckIn =?1";
        return (List<Reservation>) entityManager.createQuery(hql).setParameter(1,reservationCheckIn).getResultList();
    }
}
