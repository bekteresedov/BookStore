package com.bookStore.data.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  id;

    String name;
    String author;
    Double price;
    Integer  stock;

}
