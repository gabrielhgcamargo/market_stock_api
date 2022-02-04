package io.github.gabrielhgcamargo.model.products;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Nutrition{
    private ArrayList<Nutrient> nutrients;
    private CaloricBreakdown caloricBreakdown;
    private double calories;
    private String fat;
    private String protein;
    private String carbs;
}
