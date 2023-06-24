package com.blue.bluearchive.admin.entity;

import com.blue.bluearchive.admin.dto.CategoryDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "category_name", length = 100)
    private String categoryName;

    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}