package com.blue.bluearchive.report.controller;


import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.board.dto.BoardDto;
import com.blue.bluearchive.board.dto.BoardFormDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.report.dto.ReportBoardFormDto;
import com.blue.bluearchive.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping(value = "/report/board/{boardId}")
    public String openReport(@PathVariable int boardId, Model model) {
        Map<String, String> reportBoard;
        reportBoard=reportService.openReport(boardId);
        model.addAttribute("reportMap", reportBoard);
        return "report/reportBoard";
    }

    @PostMapping(value = "/report/board/new")
    public String reportBoardNew(@Valid ReportBoardFormDto reportBoardFormDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            System.out.println("================================신고 유효성 추가 예정==============================");
            model.addAttribute("errorMessage","신고 유효성 오류");
            return "/report/reportFalse";
        }
        try {
//            System.out.println(reportBoardFormDto);
            reportService.save(reportBoardFormDto);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errorMessage","신고 등록 중 오류");
            return "/report/reportFalse";
        }
        return "report/reportSuccess";
    }


}
