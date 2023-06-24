package com.blue.bluearchive.board.dto;


import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;


//건희 추가
@Data
public class CommentsCommentFormDto {
    @NotBlank(message = "내용은 필수 입니다")
    private String commentsCommentContent;
    private Comment comment;

    private static ModelMapper modelMapper = new ModelMapper();
    public CommentsComment createBoard(){
        return modelMapper.map(this, CommentsComment.class);
    }

    public static CommentsCommentFormDto of(CommentsComment commentsComment){
        return modelMapper.map(commentsComment, CommentsCommentFormDto.class);
    }

}
