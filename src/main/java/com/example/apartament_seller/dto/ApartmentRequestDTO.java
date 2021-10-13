package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ApartmentRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    Integer number;
    Long parentUUID;
    Integer status;
    Integer rooms;
    Long agencyId;
    Float totalArea;

    public ApartmentRequestDTO(Integer number, Long parentUUID, Integer status, Integer rooms, Long agencyId, Float totalArea) {
        this.number = number;
        this.parentUUID = parentUUID;
        this.status = status;
        this.rooms = rooms;
        this.agencyId = agencyId;
        this.totalArea = totalArea;
    }
}
