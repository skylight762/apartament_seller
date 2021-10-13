package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ApartmentByHouseDTO {
    Long totalApartments;
    Integer houseNumber;

    public ApartmentByHouseDTO(Long totalApartments, Integer houseNumber) {
this.totalApartments = totalApartments;
        this.houseNumber = houseNumber;
    }
}
