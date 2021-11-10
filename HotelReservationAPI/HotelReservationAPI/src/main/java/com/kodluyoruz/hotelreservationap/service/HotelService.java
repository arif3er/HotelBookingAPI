package com.kodluyoruz.hotelreservationap.service;

import com.kodluyoruz.hotelreservationap.exception.NotFoundException;
import com.kodluyoruz.hotelreservationap.model.dto.HotelDto;
import com.kodluyoruz.hotelreservationap.model.entity.Hotel;
import com.kodluyoruz.hotelreservationap.model.request.CreateHotelRequest;
import com.kodluyoruz.hotelreservationap.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.hotelreservationap.model.mapper.HotelMapper.HOTEL_MAPPER;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;

    public HotelDto createHotel(CreateHotelRequest request){
        Hotel hotel = HOTEL_MAPPER.createHotel(request);
        return HOTEL_MAPPER.toHotelDto(hotel);
    }

    public HotelDto getHotelDto(int id){
        Hotel hotel = getHotelEntity(id);
        return HOTEL_MAPPER.toHotelDto(hotel);
    }

    private Hotel getHotelEntity(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Visitor not found!"));
    }

    public HotelDto updateHotel(int id, CreateHotelRequest request){
        Hotel hotel = getHotelEntity(id);
        HOTEL_MAPPER.updateHotel(hotel,request);

        Hotel updatedHotel=repository.save(hotel);
        return HOTEL_MAPPER.toHotelDto(updatedHotel);
    }

    public List<HotelDto> getHotels(){
        return HOTEL_MAPPER.toHotelDtoList(repository.findAll());
    }

    public void deleteHotel(int id){
        repository.deleteById(id);
    }
}
