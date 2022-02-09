package io.github.gabrielhgcamargo.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nutrition{
    private ArrayList<Nutrient> nutrients;
    private CaloricBreakdown caloricBreakdown;
    private double calories;
    private String fat;
    private String protein;
    private String carbs;
}
