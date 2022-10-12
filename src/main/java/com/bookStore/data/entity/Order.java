package com.bookStore.data.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  id;


    private String userName;

    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer > bookIdList;

    private Double totalPrice;
}
