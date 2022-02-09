package io.github.gabrielhgcamargo.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient{
    private String name;
    private Object safety_level;
    private Object description;
}