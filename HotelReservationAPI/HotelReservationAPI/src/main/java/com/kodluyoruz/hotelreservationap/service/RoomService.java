package com.kodluyoruz.hotelreservationap.service;

import com.kodluyoruz.hotelreservationap.exception.NotFoundException;
import com.kodluyoruz.hotelreservationap.model.dto.RoomDto;
import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.entity.Room;
import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import com.kodluyoruz.hotelreservationap.model.request.CreateRoomRequest;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import com.kodluyoruz.hotelreservationap.repository.RoomRepository;
import com.kodluyoruz.hotelreservationap.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.hotelreservationap.model.mapper.RoomMapper.ROOM_MAPPER;
import static com.kodluyoruz.hotelreservationap.model.mapper.VisitorMapper.VISITOR_MAPPER;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repository;

    public RoomDto createRoomDto(CreateRoomRequest request) {
        Room room = ROOM_MAPPER.createRoom(request);
        return ROOM_MAPPER.toRoomDto(repository.save(room));
    }

    public RoomDto getRoomDto(int id){
        Room room = getRoomEntity(id);
        return ROOM_MAPPER.toRoomDto(room);
    }

    private Room getRoomEntity(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Visitor not found!"));
    }

    public RoomDto updateRoom(int id,CreateRoomRequest request){
        Room room = getRoomEntity(id);
        ROOM_MAPPER.updateRoom(room,request);

        Room updatedRoom=repository.save(room);
        return ROOM_MAPPER.toRoomDto(updatedRoom);
    }

    public List<RoomDto> getRooms(){
        return ROOM_MAPPER.toRoomDtoList(repository.findAll());
    }

    public void deleteRoom(int id){
        repository.deleteById(id);
    }
}
