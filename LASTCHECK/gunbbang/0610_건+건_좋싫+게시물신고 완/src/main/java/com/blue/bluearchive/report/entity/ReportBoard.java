package com.blue.bluearchive.report.entity;


import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.shop.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@Table(name = "reportboard")
@Setter
@Getter
@ToString
public class ReportBoard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_board_id")
    private int reportId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board boardId;

    @Column(name = "board_created_by")
    private String boardCreatedBy;

    @Column(name = "report_board_content", length = 300, nullable = false)
    private String reportBoardContent;

    @Column(name = "report_board_category", length = 30, nullable = false)
    private String reportBoardCategory;
}
