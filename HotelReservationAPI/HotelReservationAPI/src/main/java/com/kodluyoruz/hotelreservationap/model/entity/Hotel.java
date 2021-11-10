package com.kodluyoruz.hotelreservationap.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "hotels")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hotel",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Room> rooms;
}
