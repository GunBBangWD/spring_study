package com.blue.bluearchive.board.entity;

import com.blue.bluearchive.shop.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comments_comment")
@Getter @Setter
public class CommentsComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_comment_id")
    private int commentsCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private Comment comment;   //다른곳 양식상 commentId 로해야하지만 혹시몰라 comment 기준으로 구현

    @Column(name = "comments_comment_content", nullable = false)
    private String commentsCommentContent;

    @Column(name = "comments_comment_like_count")
    private Integer commentsCommentLikeCount=0; //디폴트값을 위해 건희 수정

    @Column(name = "comments_comment_hate_count")
    private Integer commentsCommentHateCount=0;//디폴트값을 위해 건희 수정

    @Column(name = "comments_comment_reports_count")
    private Integer commentsCommentReportsCount=0;//디폴트값을 위해 건희 수정

}