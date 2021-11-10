package com.kodluyoruz.hotelreservationap.service;

import com.kodluyoruz.hotelreservationap.exception.BusinessException;
import com.kodluyoruz.hotelreservationap.exception.NotFoundException;
import com.kodluyoruz.hotelreservationap.model.dto.BookingDto;
import com.kodluyoruz.hotelreservationap.model.dto.RoomDto;
import com.kodluyoruz.hotelreservationap.model.entity.Booking;
import com.kodluyoruz.hotelreservationap.model.entity.Room;
import com.kodluyoruz.hotelreservationap.model.request.CreateBookingRequest;
import com.kodluyoruz.hotelreservationap.repository.BookingRepository;
import com.kodluyoruz.hotelreservationap.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.kodluyoruz.hotelreservationap.model.mapper.BookingMapper.BOOKING_MAPPER;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    public BookingDto createBooking(CreateBookingRequest request){
        validateRoom(request);

        Booking booking = BOOKING_MAPPER.createBooking(request);
        Booking savedBooking = bookingRepository.save(booking);

        return BOOKING_MAPPER.toBookingDto(savedBooking);
    }

    private void validateRoom(CreateBookingRequest request) {
        RoomDto roomDto = roomService.getRoomDto(request.getRoomId());
        if (!roomDto.getIsAvailable()){
            throw new BusinessException("Room already registered!");
        }
    }

    public BookingDto getBookingDto(int id){
        Booking booking = getBookingEntity(id);
        return BOOKING_MAPPER.toBookingDto(booking);
    }

    private Booking getBookingEntity(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found!"));
    }

    public BookingDto updateBooking(int id, CreateBookingRequest request){
        Booking booking = getBookingEntity(id);
        BOOKING_MAPPER.updateBooking(booking,request);

        Booking updatedBooking= bookingRepository.save(booking);
        return BOOKING_MAPPER.toBookingDto(updatedBooking);
    }

    public List<BookingDto> getBookings(){
        return BOOKING_MAPPER.toBookingDtoList(bookingRepository.findAll());
    }

    public void deleteBooking(int id){
        bookingRepository.deleteById(id);
    }
}
