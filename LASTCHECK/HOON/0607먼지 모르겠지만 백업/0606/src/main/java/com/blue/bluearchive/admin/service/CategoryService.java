package com.blue.bluearchive.admin.service;

import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.admin.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    //승훈이꺼 추가
    public String normalizeCategoryName(String categoryName) {
        // 공백 및 띄어쓰기 제거
        String trimmedName = categoryName.replaceAll("\\s", "");
        // 소문자로 변환
        String lowercaseName = trimmedName.toLowerCase();
        return lowercaseName;
    }


    public void save(CategoryDto categoryDto) {
        String normalizedCategoryName = normalizeCategoryName(categoryDto.getCategoryName());
        if (isCategoryNameExists(normalizedCategoryName)) {
            throw new IllegalArgumentException("중복된 카테고리 이름입니다. 다른 이름을 입력해주세요.");
        }
        Category category = Category.toCategoryEntity(categoryDto);
        category.setCategoryName(normalizedCategoryName);
        categoryRepository.save(category);
    }
public boolean isCategoryNameExists(String categoryName) {
    return categoryRepository.existsByCategoryNameIgnoreCase(categoryName);
}
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
//public CategoryDto update(CategoryDto categoryDto) {
//    Category existingCategory = categoryRepository.findById(categoryDto.getCategoryId())
//            .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));
//
//    String newCategoryName = normalizeCategoryName(categoryDto.getCategoryName());
//    if (!existingCategory.getCategoryName().equals(newCategoryName) && isCategoryNameExists(newCategoryName)) {
//        throw new IllegalArgumentException("중복된 카테고리 이름입니다. 다른 이름을 입력해주세요.");
//    }
//
//    existingCategory.setCategoryName(newCategoryName);
//    categoryRepository.save(existingCategory);
//    return categoryDto;
//}
public CategoryDto update(CategoryDto categoryDto) {
    Category existingCategory = categoryRepository.findById(categoryDto.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

    String newCategoryName = normalizeCategoryName(categoryDto.getCategoryName());
    if (!existingCategory.getCategoryName().equals(newCategoryName) && isCategoryNameExists(newCategoryName)) {
        throw new IllegalArgumentException("중복된 카테고리 이름입니다. 다른 이름을 입력해주세요.");
    }

    existingCategory.setCategoryName(newCategoryName);
    categoryRepository.save(existingCategory);
    return categoryDto;
}


    //승훈이 추가 끝
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("카테고리를 찾을 수가 없습니다."));
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> CategoryEntities = categoryRepository.findAll();
        List<CategoryDto> CategoryDtos = new ArrayList<>();
        for (Category category : CategoryEntities) {
            CategoryDtos.add(modelMapper.map(category, CategoryDto.class));
        }
        return CategoryDtos;
    }
}