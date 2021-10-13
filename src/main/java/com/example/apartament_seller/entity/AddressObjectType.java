package com.example.apartament_seller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address_object_type")
public class AddressObjectType {
    @Id
    Long id;
    @Column(name = "short_name")
    String shortName;
    @Column(name = "full_name")
    String fullName;
}
