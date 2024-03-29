package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.CommentsComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AdminCommentsCommentRepository extends JpaRepository<CommentsComment,Integer>, QuerydslPredicateExecutor<CommentsComment>
        , AdminCommentsCommentRepositoryCustom {

    //승훈 코드 추가
    List<CommentsComment> findByComment_Board(Board boardId);

    List<CommentsComment> findByCreatedByContaining(String keyword);
    List<CommentsComment> findByCommentsCommentContentContaining(String keyword);
}
