package com.blue.bluearchive.board.dto;

import com.blue.bluearchive.board.entity.Board;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class CommentDto {
    private int commentId;
    private Board board;
    private String commentContent;
    private Integer commentLikeCount = 0;

    private Integer commentHateCount = 0;
    private Integer commentReportsCount = 0;
    private String createdBy;
    private LocalDateTime regTime;

}
