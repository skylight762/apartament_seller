package com.example.apartament_seller.controller;

import com.example.apartament_seller.dto.*;
import com.example.apartament_seller.service.HouseService;
import com.example.apartament_seller.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AgencyController {
    private final RoomService roomService;
    private final HouseService houseService;


    //первый запрос
    @GetMapping("/apartments")
    public List<RoomDTO> getRooms(@RequestParam("agency") String agency) {
        return roomService.getRooms(agency);
    }

    //второй запрос
    @GetMapping("/houses")
    public List<HouseDTO> getHouses(@RequestParam("floors") Integer floors) {
        return houseService.getHouses(floors);
    }

    //третий запрос и шестой запрос
    @GetMapping("/rooms")
    public List<RoomWithPriceDTO> getRooms(@RequestParam(value = "count", required = false) Integer count,
                                           @RequestParam(value = "streetName", required = false)String streetName,
                                           @RequestParam(value = "price", required = false)Float price) {
        if (count != null) {
            return roomService.getRoomsByRooms(count);
        } else if (streetName != null && price != null) {
            return roomService.getApartmentByStreetAndPrice(streetName, price);
        }
        return roomService.getAll();
    }

    //четвертый запрос
    @GetMapping("/apartments-by-agency")
    public List<ApartmentByAgencyDTO> getApartmentByAgency() {
        return roomService.getApartmentByAgency();
    }

    //пятый запрос

    @GetMapping("/apartment-by-house")
    public List<ApartmentByHouseDTO> getApartmentSelling() {
        return houseService.getApartmentSelling();
    }

    //добавление квартир
    @PostMapping("/apartment")
    public Long createApartment(@RequestBody ApartmentRequestDTO apartmentRequestDTO){
        return roomService.save(apartmentRequestDTO);
    }
    //обновление квартир
    @PutMapping("/apartment")
    public Long updateApartment(@RequestBody ApartmentRequestDTO apartmentRequestDTO) throws Exception {
        return roomService.update(apartmentRequestDTO);
    }
    //удаление квартир
    @DeleteMapping("/apartment")
    public void deleteApartment(@RequestBody Long id){
        roomService.deleteById(id);
    }


}
