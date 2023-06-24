package com.blue.bluearchive.board.service;

import com.blue.bluearchive.admin.repository.CategoryRepository;
import com.blue.bluearchive.board.ResourceNotFoundException;
import com.blue.bluearchive.board.dto.BoardDto;
import com.blue.bluearchive.board.dto.BoardFormDto;
import com.blue.bluearchive.board.dto.CommentDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final CommentsCommentRepository commentsCommentRepository;


    @Autowired
    public BoardService(BoardRepository boardRepository, ModelMapper modelMapper, CommentRepository commentRepository, CommentsCommentRepository commentsCommentRepository,CommentService commentService) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.commentsCommentRepository = commentsCommentRepository;
        this.commentService = commentService;
    }
    public List<BoardDto> getAllBoards() {
        List<Board> boardEntities = boardRepository.findAll();
        List<BoardDto> BoardDtos = new ArrayList<>();
        for (Board board : boardEntities) {
            BoardDtos.add(modelMapper.map(board, BoardDto.class));
        }
        return BoardDtos;
    }

    public List<BoardDto> getBoardsByCategory(Category category) {
        List<Board> boardEntities = boardRepository.findByCategory(category);
        List<BoardDto> boardDtos = new ArrayList<>();
        for (Board board : boardEntities) {
            boardDtos.add(modelMapper.map(board, BoardDto.class));
        }
        return boardDtos;
    }
    public BoardDto getBoardById(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        return modelMapper.map(board, BoardDto.class);
    }

        public void updateBoard(BoardDto boardDto) {
            // 엔티티를 업데이트하는 로직을 추가합니다.
            Board board = boardRepository.findById(boardDto.getBoardId()).orElse(null);
            if (board != null) {
                // 엔티티의 필드를 업데이트합니다.
                board.setBoardCount(board.getBoardCount());
                // Repository를 통해 엔티티를 저장 또는 업데이트합니다.
                boardRepository.save(board);
            }
        }

    public void incrementBoardCount(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        if (board != null) {
            board.setBoardCount(board.getBoardCount() + 1);
            boardRepository.save(board);
        }
    }


    public Integer saveBoard(BoardFormDto boardFormDto) throws  Exception{
        Board board = boardFormDto.createBoard();
        boardRepository.save(board);
        return board.getBoardId();
    }
    // 승훈 추가 내역
    @Autowired
    private CategoryRepository categoryRepository;

    public List<BoardDto> getBoardsByCategoryId(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        List<Board> boardEntities = boardRepository.findByCategory(category);
        List<BoardDto> boardDtos = new ArrayList<>();
        for (Board board : boardEntities) {
            boardDtos.add(modelMapper.map(board, BoardDto.class));
        }
        return boardDtos;
    }
    public void delete(int boardId) {
        // 게시물 삭제
        boardRepository.deleteById(boardId);
    }
    public List<BoardDto> searchBoards(String option, String keyword) {
        List<Board> boardEntities;
        List<BoardDto> boardDtos = new ArrayList<>();

        switch (option) {
            case "1": // 제목
                boardEntities = boardRepository.findByBoardTitleContaining(keyword);
                break;
            case "2": // 작성자
                boardEntities = boardRepository.findByCreatedByContaining(keyword);
                break;
            case "3": // 내용
                boardEntities = boardRepository.findByBoardContentContaining(keyword);
                break;
            default:
                boardEntities = Collections.emptyList();
                break;
        }

        for (Board board : boardEntities) {
            boardDtos.add(modelMapper.map(board, BoardDto.class));
        }

        return boardDtos;
    }
    public void deleteBoards(List<Integer> boardIds) {
        for (Integer boardId : boardIds) {
            Board board = boardRepository.findById(boardId).orElseThrow(NoSuchElementException::new);

            List<Comment> comments = commentRepository.findByBoardId(board);
            for (Comment comment : comments) {
                commentRepository.delete(comment);
            }


            // 댓글 삭제
            commentRepository.deleteAll(comments);

            // 게시글 삭제
            boardRepository.delete(board);
        }
    }
    //게시글 수정 부분 코드추가
    @Transactional
    public void updateCategoryNameById(int boardId, int categoryId) {
        boardRepository.updateCategoryNameById(boardId, categoryId);
    }
    public List<Comment> getCommentsByBoardId(int boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new ResourceNotFoundException("Board", "id", boardId));
        return commentRepository.findByBoardId(board);
    }
}


