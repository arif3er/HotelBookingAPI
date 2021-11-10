package com.kodluyoruz.hotelreservationap.repository;

import com.kodluyoruz.hotelreservationap.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
