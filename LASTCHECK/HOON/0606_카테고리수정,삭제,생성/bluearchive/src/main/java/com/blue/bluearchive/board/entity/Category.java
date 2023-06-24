package com.blue.bluearchive.board.entity;

import com.blue.bluearchive.board.dto.CategoryDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Board> BoardEntityList = new ArrayList<>();


    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}