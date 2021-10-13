package com.example.apartament_seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ApartmentByAgencyDTO {
    String agencyName;
    Long totalCount;
    public ApartmentByAgencyDTO(Long totalCount, String agencyName) {
        this.totalCount = totalCount;
        this.agencyName = agencyName;
    }
}
