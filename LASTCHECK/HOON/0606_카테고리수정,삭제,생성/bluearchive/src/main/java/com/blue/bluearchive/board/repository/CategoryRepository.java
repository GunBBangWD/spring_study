package com.blue.bluearchive.board.repository;

import com.blue.bluearchive.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByCategoryName(String categoryName);
}
