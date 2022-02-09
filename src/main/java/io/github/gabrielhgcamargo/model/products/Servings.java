package io.github.gabrielhgcamargo.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servings{
    private double number;
    private double size;
    private String unit;
}