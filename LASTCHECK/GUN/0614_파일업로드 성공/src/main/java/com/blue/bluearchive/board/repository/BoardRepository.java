package com.blue.bluearchive.board.repository;

import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByCategory(Category category);



}
