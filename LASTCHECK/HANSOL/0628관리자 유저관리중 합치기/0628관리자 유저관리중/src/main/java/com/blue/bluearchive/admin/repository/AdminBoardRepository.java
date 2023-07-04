package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminBoardRepository extends JpaRepository<Board,Integer>, QuerydslPredicateExecutor<Board>
        , AdminBoardRepositoryCustom {


    //승훈 코드 추가
    //승훈 게시물 검색 기능 추가
    Page<Board> findByBoardTitleContaining(String keyword, Pageable pageable);
    Page<Board> findByCreatedByContaining(String keyword,Pageable pageable);

    //  게시물 카테고리 수정 부분 코드 추가

    @Modifying
    @Query("UPDATE Board b SET b.category.categoryId = :categoryId WHERE b.boardId = :boardId")
    void updateCategoryNameById(@Param("boardId") int boardId, @Param("categoryId") int categoryId);
    List<Board> findByCategoryCategoryId(int categoryId);
}
