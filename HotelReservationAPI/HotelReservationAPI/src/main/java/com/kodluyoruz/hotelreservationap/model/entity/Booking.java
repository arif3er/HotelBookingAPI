package com.kodluyoruz.hotelreservationap.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime checkInDate;

    private Integer campaignDay;

    @Column(nullable = false)
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime checkOutDate;

    @Column(name = "room_id")
    private Integer roomId;

    @JoinColumn(name="room_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @Column(name = "visitor_id")
    private Integer visitorId;

    @JoinColumn(name="visitor_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Visitor visitor;
}
