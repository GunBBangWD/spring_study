package com.blue.bluearchive.report.repository;

import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.report.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportBoardRepository extends JpaRepository<Report,Integer> {

    //건희 추가 승훈이꺼에 사용용도
    long countByBoardBoardIdAndReportStatusFalse(int boardId);

    //승훈 추가
    List<Report> findByBoardBoardIdAndReportStatusFalse(int boardId);

    List<Report> findByCommentCommentIdAndReportStatusFalse(int commentId);

    List<Report> findByCommentsCommentCommentsCommentIdAndReportStatusFalse(int commentsId);


    Page<Report> findByCommentsCommentAndReportStatusOrderByRegTimeDesc(CommentsComment commentsComment, boolean b, Pageable pageable);
    Page<Report> findByCommentAndReportStatusOrderByRegTimeDesc(Comment comment, boolean b, Pageable pageable);
    Page<Report> findByBoardAndReportStatusOrderByRegTimeDesc(Board board, boolean b, Pageable pageable);
}
