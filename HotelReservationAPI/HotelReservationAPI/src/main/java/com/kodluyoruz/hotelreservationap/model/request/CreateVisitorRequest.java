package com.kodluyoruz.hotelreservationap.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVisitorRequest {
    private String name;
    private String surname;
}
