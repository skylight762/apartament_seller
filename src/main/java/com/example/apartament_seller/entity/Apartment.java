package com.example.apartament_seller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "apartment")
public class Apartment {
    @Id
    @SequenceGenerator(name = "apartment_id_seq",sequenceName = "apartment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_id_seq")
    Long id;
    Integer number;
    Long parentUUID;
    Integer status;
    Integer rooms;
    Long agencyId;
    Float totalArea;
}
