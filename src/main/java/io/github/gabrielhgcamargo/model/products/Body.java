package io.github.gabrielhgcamargo.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Body{

    @Column
    private int id;

    @Column
    private String title;

    @Column
    private BigDecimal price;

    @Column
    private int likes;

    @Column
    private ArrayList<String> badges;

    @Column
    private ArrayList<String> importantBadges;

    @Column
    private Nutrition nutrition;

    @Column
    private Servings servings;

    @Column
    private double spoonacularScore;

    @Column
    private ArrayList<Object> breadcrumbs;

    @Column
    private Object aisle;

    @Column
    private Object description;

    @Column
    private String image;

    @Column
    private String imageType;

    @Column
    private ArrayList<String> images;

    @Column
    private String generatedText;

    @Column
    @Id
    private String upc;

    @Column
    private Object brand;

    @Column
    private ArrayList<Ingredient> ingredients;

    @Column
    private int ingredientCount;

    @Column
    private String ingredientList;
}