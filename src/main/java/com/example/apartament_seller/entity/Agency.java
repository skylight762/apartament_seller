package com.example.apartament_seller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@NoArgsConstructor
@Table(name ="agency")
public class Agency {
    @Id
    Long id;
    String name;
}
