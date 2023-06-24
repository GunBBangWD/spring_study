package com.blue.bluearchive.board.service;

import com.blue.bluearchive.board.dto.CategoryDto;
import com.blue.bluearchive.board.entity.Category;
import com.blue.bluearchive.board.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public void save(CategoryDto categoryDto) {
        Category category = Category.toCategoryEntity(categoryDto);
        categoryRepository.save(category);
    }

    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category : categoryList){
            categoryDtoList.add(CategoryDto.toCategoryDto(category));
        }
        return categoryDtoList;
    }

    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
    public boolean isCategoryNameExists(String categoryName) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public CategoryDto findById(int id) {
        Optional<Category> categoryId = categoryRepository.findById(id);
        if (categoryId.isPresent()) {
            Category category = categoryId.get();
            CategoryDto categoryDto = CategoryDto.toCategoryDto(category);
            return categoryDto;
        }else {
            return null;
        }
    }

//    public CategoryDto update(CategoryDto categoryDto) {
//        Category category = Category.toCategoryEntity(categoryDto);
//        categoryRepository.save(category);
//        return categoryDto;
//    }
public CategoryDto update(CategoryDto categoryDto) {
    Category existingCategory = categoryRepository.findById(categoryDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

    String newCategoryName = categoryDto.getCategoryName();
    if (!existingCategory.getCategoryName().equalsIgnoreCase(newCategoryName) &&
            isCategoryNameExists(newCategoryName)) {
        throw new IllegalArgumentException("기존 이름과 동일합니다.");
    }

    existingCategory.setCategoryName(newCategoryName);
    categoryRepository.save(existingCategory);
    return categoryDto;
}
}
