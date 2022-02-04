package io.github.gabrielhgcamargo.model.products;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Body{
    private int id;
    private String title;
    private double price;
    private int likes;
    private ArrayList<String> badges;
    private ArrayList<String> importantBadges;
    private Nutrition nutrition;
    private Servings servings;
    private double spoonacularScore;
    private ArrayList<Object> breadcrumbs;
    private Object aisle;
    private Object description;
    private String image;
    private String imageType;
    private ArrayList<String> images;
    private String generatedText;
    private String upc;
    private Object brand;
    private ArrayList<Ingredient> ingredients;
    private int ingredientCount;
    private String ingredientList;
}