package com.kodluyoruz.hotelreservationap.controller;

import com.kodluyoruz.hotelreservationap.model.dto.RoomDto;
import com.kodluyoruz.hotelreservationap.model.request.CreateRoomRequest;
import com.kodluyoruz.hotelreservationap.service.RoomService;
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
public class RoomController {
    private final RoomService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto createRoom(@RequestBody CreateRoomRequest request){
        return service.createRoomDto(request);
    }

    @GetMapping("{id}")
    public RoomDto getRoom(@PathVariable int id){return service.getRoomDto(id);}

    @PutMapping("{id}")
    public RoomDto updateRoom(@PathVariable int id,@RequestBody CreateRoomRequest request){
        return  service.updateRoom(id,request);
    }

    @GetMapping
    public List<RoomDto> getRooms(){
        return service.getRooms();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable int id){service.deleteRoom(id);}
}
