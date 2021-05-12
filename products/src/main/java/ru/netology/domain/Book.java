package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {
    private String author;

    public Book (int id, String name, int price, String author) {
        super (id, name, price);
        this.author = author;
    }
}
