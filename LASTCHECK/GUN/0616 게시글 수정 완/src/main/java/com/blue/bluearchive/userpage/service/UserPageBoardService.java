package com.blue.bluearchive.userpage.service;


import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.userpage.dto.UserPageBoardDto;
import com.blue.bluearchive.userpage.dto.UserPageCommentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPageBoardService {
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    public List<UserPageBoardDto> getBoardByCreatedBy(String userIdx){
        List<Board> boardList = boardRepository.findByCreatedBy(userIdx);

        List<UserPageBoardDto> boardDtos = new ArrayList<>();
        for (Board board : boardList) {
            boardDtos.add(modelMapper.map(board, UserPageBoardDto.class));
        }
        return boardDtos;

    }

    public List<UserPageBoardDto> getBoardByCreatedBy(String userIdx,int categoryId){

        List<Board> boardList = boardRepository.findByCreatedBy(userIdx);

        List<UserPageBoardDto> boardDtos = new ArrayList<>();
        for (Board board : boardList) {
            if (board.getCategory().getCategoryId()==categoryId)
            boardDtos.add(modelMapper.map(board, UserPageBoardDto.class));
        }
        return boardDtos;

    }


}
