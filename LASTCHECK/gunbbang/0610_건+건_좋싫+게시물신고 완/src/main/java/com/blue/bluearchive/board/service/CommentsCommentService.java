package com.blue.bluearchive.board.service;

import com.blue.bluearchive.board.dto.CommentDto;
import com.blue.bluearchive.board.dto.CommentFormDto;
import com.blue.bluearchive.board.dto.CommentsCommentDto;
import com.blue.bluearchive.board.dto.CommentsCommentFormDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.shop_inquiry.entity.Inquiry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsCommentService {
    private final CommentRepository commentRepository;
    private final CommentsCommentRepository commentsCommentRepository;
    private final ModelMapper modelMapper;

    public List<CommentsCommentDto> getCommentsCommentByCommentId(int commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (comment == null) {
            // 예외 처리 또는 오류 처리
            return Collections.emptyList(); // 빈 목록 반환하거나 예외 처리 로직 추가
        }
        List<CommentsComment> commentsComments = commentsCommentRepository.findByComment(comment);
        if (commentsComments == null) {
            // 예외 처리 또는 오류 처리
            return Collections.emptyList(); // 빈 목록 반환하거나 예외 처리 로직 추가
        }
        List<CommentsCommentDto> commentsCommentDtos = new ArrayList<>();
        for(CommentsComment commentsComment : commentsComments){
            commentsCommentDtos.add(modelMapper.map(commentsComment, CommentsCommentDto.class));
        }
        return commentsCommentDtos;
    }


    //건희추가
    @Transactional(readOnly = false)
    public Integer save(CommentsCommentFormDto commentsCommentFormDto) throws  Exception{
        CommentsComment commentsComment = commentsCommentFormDto.createBoard();
        System.out.println("테스트======"+commentsComment);
        commentsCommentRepository.save(commentsComment);
        return commentsComment.getCommentsCommentId();
    }

    //건희추가
    @Transactional(readOnly = false)
    public void update(int commentsCommentId, String commentsCommentContent){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;
        String  loginMemberIdx=Long.toString(userDetails.getIdx());

        CommentsComment commentsComment = commentsCommentRepository.findById(commentsCommentId)
                .orElseThrow(()->new IllegalArgumentException("유효하지않은 ID입니다"));
        if(!commentsComment.getCreatedBy().equals(loginMemberIdx)) {
            throw new AccessDeniedException("현재 로그인되어있는 사용자와 작성자가 일치하지 않습니다");
        }
        commentsComment.setCommentsCommentContent(commentsCommentContent);
    }

    //건희추가
    @Transactional(readOnly = false)
    public void delete(int commentsCommentId) {
        CommentsComment commentsComment = commentsCommentRepository.findById(commentsCommentId)
                .orElseThrow(()->new IllegalArgumentException("유효하지않은 ID입니다"));
        commentsCommentRepository.delete(commentsComment);
    }


}
