package com.kodluyoruz.hotelreservationap.controller;

import com.kodluyoruz.hotelreservationap.model.dto.BookingDto;
import com.kodluyoruz.hotelreservationap.model.request.CreateBookingRequest;
import com.kodluyoruz.hotelreservationap.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("visitors")
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService service;

    @PostMapping
    public BookingDto booking(@RequestBody CreateBookingRequest request){
    }


}
