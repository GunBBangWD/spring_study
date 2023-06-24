package com.blue.bluearchive.report.service;


import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.report.dto.ReportBoardFormDto;
import com.blue.bluearchive.report.entity.ReportBoard;
import com.blue.bluearchive.report.repository.ReportBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportBoardRepository reportBoardRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    //건희 추가
    @Transactional(readOnly = false)
    public Integer save(ReportBoardFormDto reportBoardFormDto){
        System.out.println("==========서비스 진입===============");
        ReportBoard reportBoard = reportBoardFormDto.createReport();
        System.out.println(reportBoard);
        reportBoardRepository.save(reportBoard);

        Board board = reportBoardFormDto.getBoardId();
        board.setBoardReportsCount(board.getBoardReportsCount()+1);

        return reportBoard.getReportId();
    }

    public Map<String ,String > openReport(int boardId){
        Map<String, String> reportBoard = new HashMap<>();
        Board board = boardRepository.findById(boardId).orElseThrow();
        reportBoard.put("boardTitle",board.getBoardTitle());
        reportBoard.put("boardId",Integer.toString(board.getBoardId()));
        reportBoard.put("boardCreatedBy",board.getCreatedBy());
        System.out.println("===============================================확인용=============="+board.getCreatedBy());

        Member member = memberRepository.findById(Long.valueOf(board.getCreatedBy())).orElseThrow();
        reportBoard.put("boardNickName",member.getNickName());

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;

        reportBoard.put("nickName",userDetails.getNickName());
        reportBoard.put("createdBy",Long.toString(userDetails.getIdx()));
        return reportBoard;
    }
}
