package com.blue.bluearchive.board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_food_information")
public class CategoryFoodInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_food_information_id")
    private int categoryFoodId;

    @Column(name = "category_food_information_name")
    private String categoryFoodName;

    @Column(name = "category_food_information_size")
    private double categoryFoodSize;

    @Column(name = "category_food_information_kcal")
    private double categoryFoodKcal;

    @Column(name = "category_food_information_carb")
    private double categoryFoodCarb;

    @Column(name = "category_food_information_protein")
    private double categoryFoodProtein;

    @Column(name = "category_food_information_fat")
    private double categoryFoodFat;

}
