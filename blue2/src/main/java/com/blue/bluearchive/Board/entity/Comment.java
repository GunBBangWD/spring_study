package com.blue.bluearchive.Board.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "comment_created_by", length = 10, nullable = false)
    private String commentCreatedBy;

    @Column(name = "comment_content", length = 300, nullable = false)
    private String commentContent;

    @Column(name = "comment_time", nullable = false)
    private Timestamp commentTime;

    @Column(name = "comment_likeCount", nullable = false)
    private int commentLikeCount;

    @Column(name = "comment_hateCount", nullable = false)
    private int commentHateCount;

    @Column(name = "comment_reportsCount", nullable = false)
    private int commentReportsCount;


}