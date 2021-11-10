package com.kodluyoruz.hotelreservationap.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Integer id;
    private Integer visitorId;
    private Integer roomId;
    private Integer campaignDay;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
}
