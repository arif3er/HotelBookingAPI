package com.kodluyoruz.hotelreservationap.repository;

import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {
}
