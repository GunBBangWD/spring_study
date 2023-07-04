package com.blue.bluearchive.board.service;

import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.board.dto.BoardDto;
import com.blue.bluearchive.board.dto.BoardFormDto;
import com.blue.bluearchive.board.dto.BoardImgDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.BoardImg;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.board.repository.formRepository.BoardImgRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardImgRepository boardImgRepository;
    private final BoardImgService boardImgService;
    private final ModelMapper modelMapper;

    private final CommentRepository commentRepository;
    private final CommentsCommentRepository commentsCommentRepository;


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
    public BoardFormDto getBoardImgById(int boardId){
        List<BoardImg> boardImgList=boardImgRepository.findByBoardBoardIdOrderByBoardImgIdAsc(boardId);
        List<BoardImgDto> boardImgDtoList = new ArrayList<>();
        for(BoardImg boardImg : boardImgList){
            BoardImgDto boardImgDto = BoardImgDto.of(boardImg);
            boardImgDtoList.add(boardImgDto);
        }
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        BoardFormDto boardFormDto = BoardFormDto.of(board);
        boardFormDto.setBoardImgDtoList(boardImgDtoList);
        return boardFormDto;
    }

        public void updateBoard(BoardDto boardDto) {
            // 엔티티를 업데이트하는 로직을 추가합니다.
            Board board = boardRepository.findById(boardDto.getBoardId()).orElse(null);
            if (board != null) {
                // 엔티티의 필드를 업데이트합니다.
                board.setBoardCount(board.getBoardCount());
                board.setCommentCount(boardDto.getCommentCount());
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
    public void incrementBoardLikeCount(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        if (board != null) {
            board.setBoardLikeCount(board.getBoardLikeCount() + 1);
            boardRepository.save(board);
        }
    }
    public void incrementBoardHateCount(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        if (board != null) {
            board.setBoardHateCount(board.getBoardHateCount() + 1);
            boardRepository.save(board);
        }
    }
    public void decreaseBoardLikeCount(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        if (board != null) {
            board.setBoardLikeCount(board.getBoardLikeCount() - 1);
            boardRepository.save(board);
        }
    }
    public void decreaseBoardHateCount(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Board not found"));
        if (board != null) {
            board.setBoardHateCount(board.getBoardHateCount() - 1);
            boardRepository.save(board);
        }
    }


    public Integer saveBoard(BoardFormDto boardFormDto, List<MultipartFile> boardImgFileList) throws Exception {
        Board board = boardFormDto.createBoard();
        boardRepository.save(board);
        boolean hasNonEmptyFiles = false;

        for (MultipartFile file : boardImgFileList) {
            if (!file.isEmpty()) {
                hasNonEmptyFiles = true;
                break;
            }
        }

        if (hasNonEmptyFiles) {
            saveBoardImages(board, boardImgFileList);
        }

        return board.getBoardId();
    }
    public void saveBoardImages(Board board, List<MultipartFile> boardImgFileList) throws Exception {
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg boardImg = new BoardImg();
            boardImg.setBoard(board);
            
            boardImgService.saveBoardImg(boardImg, boardImgFileList.get(i));
        }
            
    }
    public int getBoardLikeCount(int boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);
        return (board != null) ? board.getBoardLikeCount() : 0;
    }
    public int getBoardHateCount(int boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);
        return (board != null) ? board.getBoardHateCount() : 0;
    }


}

