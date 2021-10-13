package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ApartmentByStreet {
    Integer houseNumber;
    Integer apartmentNumber;
    String streetName;
    Integer price;

    public ApartmentByStreet(String streetName,Integer houseNumber, Integer apartmentNumber, Integer price) {
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.streetName = streetName;
        this.price = price;
    }
}
