package com.blue.bluearchive.report.dto;

import com.blue.bluearchive.board.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportBoardDto {

    private Board boardId;
    private String commentContent;
    private Integer commentLikeCount = 0;

    private Integer commentHateCount = 0;
    private Integer commentReportsCount = 0;
    private String createdBy;

}
