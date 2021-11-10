package com.kodluyoruz.hotelreservationap.model.mapper;

import com.kodluyoruz.hotelreservationap.model.dto.BookingDto;
import com.kodluyoruz.hotelreservationap.model.entity.Booking;
import com.kodluyoruz.hotelreservationap.model.request.CreateBookingRequest;
import org.apache.commons.lang3.time.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper BOOKING_MAPPER = Mappers.getMapper(BookingMapper.class);

    BookingDto toBookingDto(Booking booking);

    List<BookingDto> toBookingDtoList(List<Booking> bookings);

    @Mapping(source = "campaignDay",target = "checkOutDate",qualifiedByName = "checkOutDateConversion")
    Booking createBooking(CreateBookingRequest request);

    @Named("checkOutDateConversion")
    static LocalDateTime checkOutDateConversion(CreateBookingRequest request,int campaignDay){
        return LocalDateTime.from(request.getCheckInDate().plusDays(campaignDay));
    }

    void updateBooking(@MappingTarget Booking booking, CreateBookingRequest request);
}
