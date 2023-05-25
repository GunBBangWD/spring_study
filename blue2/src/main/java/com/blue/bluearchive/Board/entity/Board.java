package com.blue.bluearchive.Board.entity;

import com.blue.bluearchive.member.entity.Member;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "board_count", nullable = false)
    private int boardCount;

    @Column(name = "board_created_by", nullable = false)
    private String boardCreatedBy;

    @Column(name = "board_hate_count", nullable = false)
    private int boardHateCount;

    @Column(name = "board_like_count", nullable = false)
    private int boardLikeCount;

    @Column(name = "board_pre_count", nullable = false)
    private int boardPreCount;

    @Column(name = "board_reports_count", nullable = false)
    private int boardReportsCount;

    @Column(name = "board_time", nullable = false)
    private LocalDateTime boardTime;

    @Column(name = "board_title", nullable = false)
    private String boardTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
