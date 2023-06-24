package com.blue.bluearchive.board.entity;

import com.blue.bluearchive.shop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comments_comment")
public class CommentsComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_comment_id")
    private int commentsCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private Comment comment;

    @Column(name = "comments_comment_content", nullable = false)
    private String commentsCommentContent;

    @Column(name = "comments_comment_like_count")
    private Integer commentsCommentLikeCount=0;

    @Column(name = "comments_comment_hate_count")
    private Integer commentsCommentHateCount=0;

    @Column(name = "comments_comment_reports_count")
    private Integer commentsCommentReportsCount=0;

}