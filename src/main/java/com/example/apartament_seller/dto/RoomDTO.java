package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RoomDTO {
    String addressObjectType;
    String streetName;
    Integer houseNumber;
    Integer apartmentNumber;
    Integer roomCount;
    String agencyName;

    public RoomDTO(String addressObjectType, String streetName, Integer houseNumber, Integer apartmentNumber, Integer roomCount, String agencyName) {
        this.addressObjectType = addressObjectType;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.roomCount = roomCount;
        this.agencyName = agencyName;

    }
}
