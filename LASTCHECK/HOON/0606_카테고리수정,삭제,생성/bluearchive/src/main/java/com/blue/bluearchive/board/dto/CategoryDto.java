package com.blue.bluearchive.board.dto;

import com.blue.bluearchive.board.entity.Category;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private int id;
    private String categoryName;

    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }

}
