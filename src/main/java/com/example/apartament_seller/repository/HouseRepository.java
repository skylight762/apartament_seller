package com.example.apartament_seller.repository;


import com.example.apartament_seller.dto.ApartmentByHouseDTO;
import com.example.apartament_seller.dto.HouseDTO;
import com.example.apartament_seller.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = "select new com.example.apartament_seller.dto.HouseDTO(aot.shortName, s.streetName, h.number, h.floors, h.sqMeterPrice) " +
            "from House h " +
            "join Street s on s.id=h.parentUUID " +
            "join AddressObjectType aot on aot.id = s.addressObjectTypeId " +
            "where h.floors = :floors")
    List<HouseDTO> getHousesBySQMeterPrice(@Param("floors") Integer floors);

    @Query(value = "select new com.example.apartament_seller.dto.ApartmentByHouseDTO(count (a.id), h.number) " +
            "from Apartment a " +
            "join  House h on a.parentUUID = h.id " +
            "where a.status=2 " +
            "group by h.number")
    List<ApartmentByHouseDTO> getApartmentSelling();
}
