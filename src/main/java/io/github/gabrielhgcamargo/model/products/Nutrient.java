package io.github.gabrielhgcamargo.model.products;

import lombok.Data;

@Data
public class Nutrient{
    private String name;
    private double amount;
    private String unit;
    private double percentOfDailyNeeds;
}