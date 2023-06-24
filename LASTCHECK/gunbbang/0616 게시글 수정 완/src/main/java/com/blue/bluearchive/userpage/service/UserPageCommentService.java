package com.blue.bluearchive.userpage.service;

import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.userpage.dto.UserPageCommentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPageCommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final CommentsCommentRepository commentsCommentRepository;




    //건희추가 댓글 내역 가져오기
    @Transactional(readOnly = true)
    public List<UserPageCommentDto> getCommentByCreatedBy(String memberIdx) {
        List<Comment> comments = commentRepository.findByCreatedBy(memberIdx);
        System.out.println("=====================인자 1개 서비스부분 댓글내역 확인용 ==================");
        List<UserPageCommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentDtos.add(modelMapper.map(comment, UserPageCommentDto.class));

            //대댓글 개수 가져오기
            List<CommentsComment> commentsComments = commentsCommentRepository.findByComment(comment);
            commentDtos.get(commentDtos.size()-1).setCommentsCommentCount(commentsComments.size());
        }
        return commentDtos;
    }
    //건희추가 댓글 내역 가져오기
    @Transactional(readOnly = true)
    public List<UserPageCommentDto> getCommentByCreatedBy(String memberIdx, int categoryId) {
        System.out.println("==============서비스부분 댓글 카테고리 진입==========");
        List<Comment> comments = commentRepository.findByCreatedBy(memberIdx);

        List<UserPageCommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getBoard().getCategory().getCategoryId()==categoryId){
                System.out.println("==============서비스부분 댓글 카테고리 아이디 확인==========");
                System.out.println(comment.getBoard().getCategory().getCategoryId());
                commentDtos.add(modelMapper.map(comment, UserPageCommentDto.class));

                commentDtos.get(commentDtos.size()-1).setCommentsCommentCount(comment.getCommentsComment().size());
            }
        }
        return commentDtos;
    }
}
