package com.kodluyoruz.hotelreservationap.repository;

import com.kodluyoruz.hotelreservationap.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


}
