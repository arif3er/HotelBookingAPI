package com.kodluyoruz.hotelreservationap.model.mapper;

import com.kodluyoruz.hotelreservationap.model.dto.RoomDto;
import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.entity.Room;
import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import com.kodluyoruz.hotelreservationap.model.request.CreateRoomRequest;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);

    RoomDto toRoomDto(Room room);

    List<RoomDto> toRoomDtoList(List<Room> rooms);

    Room createRoom(CreateRoomRequest request);

    void updateRoom(@MappingTarget Room room, CreateRoomRequest request);

}
