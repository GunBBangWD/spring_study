package com.blue.bluearchive.Board.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category_activity")
public class CategoryActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_activity_id")
    private int categoryActivityId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


}