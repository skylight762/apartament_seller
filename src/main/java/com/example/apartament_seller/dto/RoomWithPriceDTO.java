package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RoomWithPriceDTO {
    String addressObjectType;
    String streetName;
    Integer houseNumber;
    Integer apartmentNumber;
    Integer roomCount;
    Float totalPrice;


    public RoomWithPriceDTO(String addressObjectType, String streetName, Integer houseNumber,
                            Integer apartmentNumber, Integer roomCount,Float totalArea, Float sqMeterPrice) {
        this.addressObjectType = addressObjectType;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.roomCount = roomCount;
        this.totalPrice = sqMeterPrice*totalArea;
    }
}
