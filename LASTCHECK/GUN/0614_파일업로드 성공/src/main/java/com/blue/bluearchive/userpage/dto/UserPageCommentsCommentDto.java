package com.blue.bluearchive.userpage.dto;

import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class UserPageCommentsCommentDto {
    private int commentsCommentId;
    private String commentsCommentContent;

    private Comment comment;

    private String createdBy;
    private LocalDateTime regTime;

}
