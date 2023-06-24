package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // 추가적인 쿼리 메소드 선언 가능
    
    //승훈이 추가
    boolean existsByCategoryName(String categoryName); //이름 같은거 있는지 확인
}
