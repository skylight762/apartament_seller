package com.example.apartament_seller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "house")
public class House {
    @Id
    Long id;
    @Column(name = "number")
    Integer number;
    @Column(name = "parentuuid")
    Long parentUUID;
    @Column(name = "sq_meter_price")
    Float sqMeterPrice;
    @Column(name = "floors")
    Integer floors;
}
