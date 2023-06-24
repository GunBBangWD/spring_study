package com.blue.bluearchive.board.dto;

import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.member.entity.Member;
import lombok.Data;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class BoardForm2Dto {

    @NotBlank(message = "제목은 필수 입니다")
    private String boardTitle;
    @NotBlank(message = "내용은 필수 입니다")
    private String boardContent;

    private Category category;
    private Member member_idx;



    private static ModelMapper modelMapper = new ModelMapper();

    public Board createBoard(){
        return modelMapper.map(this, Board.class);
    }
    public static BoardFormDto of(Board board){
        return modelMapper.map(board, BoardFormDto.class);
    }

}