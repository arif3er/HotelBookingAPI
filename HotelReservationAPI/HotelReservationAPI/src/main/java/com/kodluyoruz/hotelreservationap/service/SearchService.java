package com.kodluyoruz.hotelreservationap.service;

import com.kodluyoruz.hotelreservationap.repository.BookingRepository;
import com.kodluyoruz.hotelreservationap.repository.HotelRepository;
import com.kodluyoruz.hotelreservationap.repository.RoomRepository;
import com.kodluyoruz.hotelreservationap.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final VisitorRepository visitorRepository;
    private final RoomRepository roomRepository;
}
