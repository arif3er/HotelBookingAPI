package com.kodluyoruz.hotelreservationap.model.mapper;

import com.kodluyoruz.hotelreservationap.model.dto.HotelDto;
import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.entity.Hotel;
import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import com.kodluyoruz.hotelreservationap.model.request.CreateHotelRequest;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelMapper HOTEL_MAPPER = Mappers.getMapper(HotelMapper.class);

    HotelDto toHotelDto(Hotel hotel);

    List<HotelDto> toHotelDtoList(List<Hotel> hotels);

    Hotel createHotel(CreateHotelRequest request);

    void updateHotel(@MappingTarget Hotel hotel, CreateHotelRequest request);

}
