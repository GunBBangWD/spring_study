package com.blue.bluearchive.userpage.entity;
import com.blue.bluearchive.member.entity.Member;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "member_body_information")
public class MemberBodyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_body_information")
    private int memberBodyInformationId;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @Column(name = "member_weight", nullable = false)
    private int memberWeight;

}