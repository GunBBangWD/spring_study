package com.blue.bluearchive.admin.service;


import com.blue.bluearchive.admin.dto.AdminCommentDto;
import com.blue.bluearchive.admin.dto.AdminSearchDto;
import com.blue.bluearchive.admin.repository.AdminBoardRepository;
import com.blue.bluearchive.admin.repository.AdminCommentRepository;
import com.blue.bluearchive.admin.repository.AdminCommentsCommentRepository;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.report.repository.ReportBoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCommentService {
    private final AdminCommentRepository adminCommentRepository;
    private final ReportBoardRepository reportBoardRepository;
    private final AdminCommentsCommentRepository adminCommentsCommentRepository;
    private final AdminBoardRepository adminBoardRepository;
    private final CommentsCommentRepository commentsCommentRepository;
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    private Page<AdminCommentDto> getComment(Page<Comment> comments) {
        List<AdminCommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments.getContent()) {
            commentDtos.add(modelMapper.map(comment, AdminCommentDto.class));
            int size = reportBoardRepository.findByCommentCommentIdAndReportStatusFalse(comment.getCommentId()).size();
            commentDtos.get(commentDtos.size()-1).setNotReportCount(size);
        }
        long total = comments.getTotalElements();
        return new PageImpl<>(commentDtos, comments.getPageable(), total);
    }

    @Transactional(readOnly = true)
    public Page<AdminCommentDto> getCommentByCreatedBy(int categoryid, AdminSearchDto searchDto, Pageable pageable){
        Page<AdminCommentDto> adminCommentDtoPage = null;
        Page<Comment> boardCommentPage =null;
        if(categoryid==0){
           boardCommentPage = adminCommentRepository.getCommentPage(searchDto, pageable);
            adminCommentDtoPage = getComment(boardCommentPage);
        }else{
            boardCommentPage = adminCommentRepository.getBoardCommentPage(categoryid, searchDto, pageable);
            adminCommentDtoPage = getComment(boardCommentPage);
        }
        return adminCommentDtoPage;
    }


    //승훈 코드 추가


    public List<AdminCommentDto> getCommentsByCategoryId(int categoryId) {
        List<AdminCommentDto> commentDtos = new ArrayList<>();

        if(categoryId == 0){
            List<Board> boards = adminBoardRepository.findAll();

            for (Board board : boards) {
                List<Comment> comments = commentRepository.findByBoard(board);
                for (Comment comment : comments) {
                    AdminCommentDto commentDto = modelMapper.map(comment, AdminCommentDto.class);
                    int size = reportBoardRepository.findByCommentCommentIdAndReportStatusFalse(comment.getCommentId()).size();
                    commentDtos.add(commentDto);
                    commentDtos.get(commentDtos.size()-1).setNotReportCount(size);
                }
            }
        }else{
            List<Board> boards = adminBoardRepository.findByCategoryCategoryId(categoryId);

            for (Board board : boards) {
                List<Comment> comments = commentRepository.findByBoard(board);
                for (Comment comment : comments) {
                    AdminCommentDto commentDto = modelMapper.map(comment, AdminCommentDto.class);
                    commentDtos.add(commentDto);
                    int size = reportBoardRepository.findByCommentCommentIdAndReportStatusFalse(comment.getCommentId()).size();
                    commentDtos.get(commentDtos.size()-1).setNotReportCount(size);
                }
            }
        }

        return commentDtos;
    }

    public List<AdminCommentDto> searchComments(String option, String keyword) {
        List<Comment> commentEntities;
        List<AdminCommentDto> commentDtos = new ArrayList<>();

        switch (option) {
            case "1": // 작성자
                commentEntities = adminCommentRepository.findByCreatedByContaining(keyword);
                break;
            case "2": // 내용
                commentEntities = adminCommentRepository.findByCommentContentContaining(keyword);
                break;
            default:
                commentEntities = Collections.emptyList();
                break;
        }

        for (Comment comment : commentEntities) {
            commentDtos.add(modelMapper.map(comment, AdminCommentDto.class));
            int size = reportBoardRepository.findByCommentCommentIdAndReportStatusFalse(comment.getCommentId()).size();
            commentDtos.get(commentDtos.size()-1).setNotReportCount(size);
        }

        return commentDtos;
    }

    public void deletes(List<Integer> comments) {
        for (Integer commentId : comments) {
            // Retrieve the reply by its ID
            Comment comment = commentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid commentsCommentId: " + commentId));
            commentRepository.deleteById(comment.getCommentId());
        }
    }

}
