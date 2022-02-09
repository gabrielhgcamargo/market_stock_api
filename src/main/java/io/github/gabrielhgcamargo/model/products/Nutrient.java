package io.github.gabrielhgcamargo.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nutrient{
    private String name;
    private double amount;
    private String unit;
    private double percentOfDailyNeeds;
}