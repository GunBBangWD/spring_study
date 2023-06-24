package com.blue.bluearchive.report.dto;

import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import lombok.Data;

@Data
public class ReportdDto {
    private int target;
    private String targetTitle;
    private String targetContent;
    private String targetCreatedBy;
    private String targetNickName;
    private String reportContent;
    private String reportCategory;
    private String nickName;
}
