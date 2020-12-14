package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TShirt extends Product {
    private String brand;

    public TShirt(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public boolean matches(String search) {
        return super.matches(search) || this.getBrand().equalsIgnoreCase(search);
    }
}