package com.blue.bluearchive.board.repository;

import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBoard(Board boardId);

    //건희추가 유저페이지 부분 사용
    List<Comment> findByCreatedBy(String createdBy);

    int countByBoard(Board boardId);


}
