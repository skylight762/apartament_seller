package com.example.apartament_seller.service;

import com.example.apartament_seller.dto.ApartmentByAgencyDTO;
import com.example.apartament_seller.dto.ApartmentRequestDTO;
import com.example.apartament_seller.dto.RoomDTO;
import com.example.apartament_seller.dto.RoomWithPriceDTO;
import com.example.apartament_seller.entity.Apartment;
import com.example.apartament_seller.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {


    private final ApartmentRepository repository;


    public List<RoomDTO> getRooms(String agencyName) {
        return repository.getRoomsByAgencyName(agencyName);
    }

    public List<RoomWithPriceDTO> getRoomsByRooms(Integer room) {
        return repository.getRoomsByRoomsCountWithPrice(room);
    }

    public List<ApartmentByAgencyDTO> getApartmentByAgency() {
        return repository.getApartmentByAgency();
    }

    public List<RoomWithPriceDTO> getApartmentByStreetAndPrice(String streetName, Float price) {
        return repository.getApartmentByStreetAndPrice(streetName, price);
    }

    public List<RoomWithPriceDTO> getAll() {
        return repository.getRoomWithPriceDTO();
    }

    public Long save(ApartmentRequestDTO apartmentRequestDTO) {
        Apartment ap = new Apartment().
                setNumber(apartmentRequestDTO.getNumber()).
                setParentUUID(apartmentRequestDTO.getParentUUID()).
                setStatus(apartmentRequestDTO.getStatus()).
                setRooms(apartmentRequestDTO.getRooms()).
                setAgencyId(apartmentRequestDTO.getAgencyId()).
                setTotalArea(apartmentRequestDTO.getTotalArea());
        return repository.save(ap).getId();
    }

    public Long update(ApartmentRequestDTO apartmentRequestDTO) throws Exception {
        Apartment ap = repository.findById(apartmentRequestDTO.getId()).orElseThrow(()->new Exception());
        ap.setNumber(apartmentRequestDTO.getNumber()).
                setParentUUID(apartmentRequestDTO.getParentUUID()).
                setStatus(apartmentRequestDTO.getStatus()).
                setRooms(apartmentRequestDTO.getRooms()).
                setAgencyId(apartmentRequestDTO.getAgencyId()).
                setTotalArea(apartmentRequestDTO.getTotalArea());
        return repository.save(ap).getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
