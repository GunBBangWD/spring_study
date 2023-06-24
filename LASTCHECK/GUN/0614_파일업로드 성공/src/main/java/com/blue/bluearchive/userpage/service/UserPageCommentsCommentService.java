package com.blue.bluearchive.userpage.service;


import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.userpage.dto.UserPageCommentDto;
import com.blue.bluearchive.userpage.dto.UserPageCommentsCommentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPageCommentsCommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final CommentsCommentRepository commentsCommentRepository;



    //건희추가 댓글 내역 가져오기
    @Transactional(readOnly = true)
    public List<UserPageCommentsCommentDto> getCommentsCommentByCreatedBy(String memberIdx) {
        List<CommentsComment> commentsComments = commentsCommentRepository.findByCreatedBy(memberIdx);
        System.out.println("=====================인자 1개 서비스부분 댓글내역 확인용 ==================");
        List<UserPageCommentsCommentDto> commentsCommentDtos = new ArrayList<>();
        for (CommentsComment commentsComment : commentsComments) {
            commentsCommentDtos.add(modelMapper.map(commentsComment, UserPageCommentsCommentDto.class));
        }
        return commentsCommentDtos;
    }
}
