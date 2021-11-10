package com.kodluyoruz.hotelreservationap.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Integer id;
    private String name;
    private String city;
}
