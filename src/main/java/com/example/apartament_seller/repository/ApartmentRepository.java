package com.example.apartament_seller.repository;

import com.example.apartament_seller.dto.ApartmentByAgencyDTO;
import com.example.apartament_seller.dto.RoomDTO;
import com.example.apartament_seller.dto.RoomWithPriceDTO;
import com.example.apartament_seller.entity.Apartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {


    @Query(value = "select new com.example.apartament_seller.dto.RoomDTO(aot.fullName,s.streetName,h.number,a.number, a.rooms, ag.name) \n" +
            "from AddressObjectType as aot \n" +
            "join Street s on aot.id=s.addressObjectTypeId \n" +
            "join House h on h.parentUUID=s.id \n" +
            "join Apartment a on a.parentUUID=h.id \n " +
            "join Agency ag on ag.id=a.agencyId \n" +
            "where ag.name = :agency")
    List<RoomDTO> getRoomsByAgencyName(@Param("agency") String agency);

    @Query(value = "select new com.example.apartament_seller.dto.RoomWithPriceDTO(aot.shortName, s.streetName, h.number, a.number, a.rooms, a.totalArea, h.sqMeterPrice) " +
            "from Apartment a " +
            "join House h on h.id=a.parentUUID " +
            "join Street s on s.id=h.parentUUID " +
            "join AddressObjectType aot on aot.id = s.addressObjectTypeId " +
            "where a.rooms = :room")
    List<RoomWithPriceDTO> getRoomsByRoomsCountWithPrice(@Param("room") Integer room);

    @Query(value = "select new com.example.apartament_seller.dto.ApartmentByAgencyDTO( count(ag.id),ag.name) " +
            "from Apartment a " +
            "join Agency ag on a.agencyId=ag.id " +
            "group by ag.name")
    List<ApartmentByAgencyDTO> getApartmentByAgency();

    @Query(value = "select new com.example.apartament_seller.dto.RoomWithPriceDTO(aot.shortName, s.streetName, h.number, a.number, a.rooms, a.totalArea, h.sqMeterPrice) " +
            "from Apartment a " +
            "join House h on h.id=a.parentUUID " +
            "join Street s on s.id=h.parentUUID " +
            "join AddressObjectType aot on aot.id = s.addressObjectTypeId " +
            "where s.streetName = :streetName and h.sqMeterPrice*a.totalArea<:price ")
    List<RoomWithPriceDTO> getApartmentByStreetAndPrice(@Param("streetName") String streetName,
                                                        @Param("price") Float price);

    @Query(value = "select new com.example.apartament_seller.dto.RoomWithPriceDTO(aot.shortName, s.streetName, h.number, a.number, a.rooms, a.totalArea, h.sqMeterPrice) " +
            "from Apartment a " +
            "join House h on h.id=a.parentUUID " +
            "join Street s on s.id=h.parentUUID " +
            "join AddressObjectType aot on aot.id = s.addressObjectTypeId")
    List<RoomWithPriceDTO> getRoomWithPriceDTO();


}

