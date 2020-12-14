package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        if (this.getName().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}