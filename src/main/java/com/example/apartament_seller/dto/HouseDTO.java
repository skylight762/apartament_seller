package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class HouseDTO {
    AddressSocr address;
    Integer houseNumber;
    Integer floors;
    Float sqMeterPrice;

    public HouseDTO(String socr, String address,Integer houseNumber, Integer floors, Float sqMeterPrice) {
        this.floors = floors;
        this.sqMeterPrice = sqMeterPrice;
        this.houseNumber = houseNumber;
        this.address=new AddressSocr(socr, address);
    }
}
