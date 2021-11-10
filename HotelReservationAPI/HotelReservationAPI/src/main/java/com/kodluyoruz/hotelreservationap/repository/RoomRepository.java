package com.kodluyoruz.hotelreservationap.repository;

import com.kodluyoruz.hotelreservationap.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("update #{#entityName} b set b.isAvailable = :isAvailable")
    int setAvailability(@Param("id") Integer id,@Param("isAvailable") boolean isAvailable);
}
