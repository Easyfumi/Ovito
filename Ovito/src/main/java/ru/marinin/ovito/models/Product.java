package ru.marinin.ovito.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

    public Product() {
    }

    public Product(String title, String description, int price, String city, String author) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.city = city;
        this.author = author;
    }
}
