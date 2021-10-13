package com.example.apartament_seller.service;

import com.example.apartament_seller.dto.ApartmentByHouseDTO;
import com.example.apartament_seller.dto.HouseDTO;
import com.example.apartament_seller.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {
    private final HouseRepository repository;

    public List<HouseDTO> getHouses(Integer floors){
        return repository.getHousesBySQMeterPrice(floors);
    }

    public List<ApartmentByHouseDTO> getApartmentSelling(){
        return repository.getApartmentSelling();
    }
 }
