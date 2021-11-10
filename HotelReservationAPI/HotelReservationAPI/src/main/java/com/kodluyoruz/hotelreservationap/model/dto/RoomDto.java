package com.kodluyoruz.hotelreservationap.model.dto;

import com.kodluyoruz.hotelreservationap.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer id;
    private Integer roomNumber;
    private Integer hotelId;
    private RoomType roomType;
    private Double price;
    private Boolean isAvailable;
}
