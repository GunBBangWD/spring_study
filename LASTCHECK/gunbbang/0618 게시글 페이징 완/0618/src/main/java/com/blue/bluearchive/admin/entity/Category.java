package com.blue.bluearchive.admin.entity;

import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.BoardImg;
import com.blue.bluearchive.userpage.entity.UserInterestCount;
import com.blue.bluearchive.userpage.entity.UserInterestLog;
import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserInterestCount> userInterestCount;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserInterestLog> userInterestLog;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> board;


    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}