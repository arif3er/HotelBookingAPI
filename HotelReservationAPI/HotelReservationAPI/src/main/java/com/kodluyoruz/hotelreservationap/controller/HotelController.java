package com.kodluyoruz.hotelreservationap.controller;

import com.kodluyoruz.hotelreservationap.model.dto.HotelDto;
import com.kodluyoruz.hotelreservationap.model.dto.RoomDto;
import com.kodluyoruz.hotelreservationap.model.entity.Hotel;
import com.kodluyoruz.hotelreservationap.model.request.CreateHotelRequest;
import com.kodluyoruz.hotelreservationap.model.request.CreateRoomRequest;
import com.kodluyoruz.hotelreservationap.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("visitors")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDto createHotel(@RequestBody CreateHotelRequest request){
        return service.createHotel(request);
    }

    @GetMapping("{id}")
    public HotelDto getHotel(@PathVariable int id){return service.getHotelDto(id);}

    @PutMapping("{id}")
    public HotelDto updateHotel(@PathVariable int id,@RequestBody CreateHotelRequest request){
        return service.updateHotel(id,request);
    }

    @GetMapping
    public List<HotelDto> getHotel(){
        return service.getHotels();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable int id){service.deleteHotel(id);}
}
