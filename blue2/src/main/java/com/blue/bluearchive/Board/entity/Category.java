package com.blue.bluearchive.Board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", length = 100)
    private String categoryName;

    @Column(name = "category_food")
    private boolean categoryFood;

    @Column(name = "category_activity")
    private boolean categoryActivity;

    @Column(name = "category_place")
    private boolean categoryPlace;

    @Column(name = "category_body")
    private boolean categoryBody;

}