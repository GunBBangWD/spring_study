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
    public void save(CategoryDto categoryDto) {
        Category category = Category.toCategoryEntity(categoryDto);
        categoryRepository.save(category);
    }
    public boolean isCategoryNameExists(String categoryName) {  // 동일한 카테고리 확인
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDto update(CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(categoryDto.getCategoryId())
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
    //승훈이 추가 끝






    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> CategoryEntities = categoryRepository.findAll();

        List<CategoryDto> CategoryDtos = new ArrayList<>();
        for (Category category : CategoryEntities) {
            System.out.println("================카테고리 출력 부분=================");
            System.out.println(category.getCategoryName());
            CategoryDtos.add(modelMapper.map(category, CategoryDto.class));
        }
        System.out.println("================카테고리 출력 부분=================");
        System.out.println(CategoryDtos);
        return CategoryDtos;
    }
}