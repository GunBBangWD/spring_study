package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCommentRepository extends JpaRepository<Comment,Integer>, QuerydslPredicateExecutor<Comment>
        , AdminCommentRepositoryCustom {

    List<Comment> findByCreatedByContaining(String keyword);

    List<Comment> findByCommentContentContaining(String keyword);
}
