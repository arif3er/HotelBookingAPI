package com.kodluyoruz.hotelreservationap.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {
    private Integer visitorId;
    private Integer roomId;
    private Integer campaignDay;
    private LocalDateTime checkInDate;
    //private Date checkOutDate;
}
