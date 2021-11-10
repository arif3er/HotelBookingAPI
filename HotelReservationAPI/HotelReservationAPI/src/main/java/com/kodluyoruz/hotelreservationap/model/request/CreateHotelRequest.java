package com.kodluyoruz.hotelreservationap.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateHotelRequest {
    private String name;
    private Integer point;
}
