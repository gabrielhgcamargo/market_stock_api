package io.github.gabrielhgcamargo.model.products;

import lombok.Data;

@Data
public class Ingredient{
    private String name;
    private Object safety_level;
    private Object description;
}