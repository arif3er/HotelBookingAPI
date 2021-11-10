package com.kodluyoruz.hotelreservationap.model.request;

import com.kodluyoruz.hotelreservationap.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest {
    private Integer hotelId;
    private Integer roomNumber;
    private RoomType roomType;
    private Double price;
}
