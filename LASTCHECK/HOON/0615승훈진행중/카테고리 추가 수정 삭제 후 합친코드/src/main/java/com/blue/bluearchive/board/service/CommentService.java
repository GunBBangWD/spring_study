package com.blue.bluearchive.board.service;

import com.blue.bluearchive.admin.repository.CategoryRepository;
import com.blue.bluearchive.board.dto.*;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    public List<CommentDto> getCommentByBoardId(int boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        if (board == null) {
            // 예외 처리 또는 오류 처리
            return Collections.emptyList(); // 빈 목록 반환하거나 예외 처리 로직 추가
        }

        List<Comment> comments = commentRepository.findByBoardId(board);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentDtos.add(modelMapper.map(comment, CommentDto.class));
        }
        return commentDtos;
    }


    //건희 추가
    public Integer saveBoard(CommentFormDto commentFormDto) throws  Exception{
        Comment comment = commentFormDto.createBoard();
        commentRepository.save(comment);
        return comment.getCommentId();
    }

    //승훈 추가
    private final CategoryRepository categoryRepository;
    public List<CommentDto> getCommentsByBoardId(int boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            // 예외 처리 또는 오류 처리
            return Collections.emptyList();
        }
        List<Comment> comments = commentRepository.findByBoardId(board);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentDtos.add(modelMapper.map(comment, CommentDto.class));
        }
        return commentDtos;
    }
    public void deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
    }

    //승훈 코드 추가

    public List<CommentDto> getComments() {
        List<CommentDto> commentDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            List<Comment> comments = commentRepository.findByBoardId(board);
            for (Comment comment : comments) {
                CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
                commentDtos.add(commentDto);
            }
        }
        return commentDtos;
    }
    public List<CommentDto> getCommentsByCategoryId(int categoryId) {
        List<CommentDto> commentDtos = new ArrayList<>();

        if(categoryId == 0){
            List<Board> boards = boardRepository.findAll();

            for (Board board : boards) {
                List<Comment> comments = commentRepository.findByBoardId(board);
                for (Comment comment : comments) {
                    CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
                    commentDtos.add(commentDto);
                }
            }
        }else{
            List<Board> boards = boardRepository.findByCategoryCategoryId(categoryId);

            for (Board board : boards) {
                List<Comment> comments = commentRepository.findByBoardId(board);
                for (Comment comment : comments) {
                    CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
                    commentDtos.add(commentDto);
                }
            }
        }

        return commentDtos;
    }
}
