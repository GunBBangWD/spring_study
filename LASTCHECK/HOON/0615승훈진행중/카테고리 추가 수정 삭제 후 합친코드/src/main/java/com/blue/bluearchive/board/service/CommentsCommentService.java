package com.blue.bluearchive.board.service;

import com.blue.bluearchive.board.dto.CommentDto;
import com.blue.bluearchive.board.dto.CommentFormDto;
import com.blue.bluearchive.board.dto.CommentsCommentDto;
import com.blue.bluearchive.board.dto.CommentsCommentFormDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public Integer saveBoard(CommentsCommentFormDto commentsCommentFormDto) throws  Exception{
        CommentsComment commentsComment = commentsCommentFormDto.createBoard();
        commentsCommentRepository.save(commentsComment);
        return commentsComment.getCommentsCommentId();
    }

    //승훈 코드 추가
    private final BoardRepository boardRepository;
    public List<CommentsCommentDto> getCommentsCommentByCategoryId(int categoryId) {
        List<CommentsCommentDto> commentsCommentDtos = new ArrayList<>();

        if(categoryId == 0){
            List<Board> boards = boardRepository.findAll();

            for (Board board : boards) {
                List<CommentsComment> commentsComments = commentsCommentRepository.findByComment_BoardId(board);
                for (CommentsComment commentsComment : commentsComments) {
                    CommentsCommentDto commentsCommentDtoDto = modelMapper.map(commentsComment, CommentsCommentDto.class);
                    commentsCommentDtos.add(commentsCommentDtoDto);
                }
            }
        }else{
            List<Board> boards = boardRepository.findByCategoryCategoryId(categoryId);

            for (Board board : boards) {
                List<CommentsComment> comments = commentsCommentRepository.findByComment_BoardId(board);
                for (CommentsComment commentsComment : comments) {
                    CommentsCommentDto commentsCommentDto = modelMapper.map(commentsComment, CommentsCommentDto.class);
                    commentsCommentDtos.add(commentsCommentDto);
                }
            }
        }

        return commentsCommentDtos;
    }

    public List<CommentsCommentDto> getCommentsComment() {
        List<CommentsCommentDto> commentsCommentDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            List<CommentsComment> commentsComments = commentsCommentRepository.findByComment_BoardId(board);
            for (CommentsComment commentsComment : commentsComments) {
                CommentsCommentDto commentsCommentDto = modelMapper.map(commentsComment, CommentsCommentDto.class);
                commentsCommentDtos.add(commentsCommentDto);
            }
        }
        return commentsCommentDtos;
    }
}
