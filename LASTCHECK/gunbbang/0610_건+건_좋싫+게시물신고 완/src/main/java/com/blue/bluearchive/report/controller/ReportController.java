package com.blue.bluearchive.report.controller;


import com.blue.bluearchive.report.dto.ReportBoardFormDto;
import com.blue.bluearchive.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

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
            System.out.println(reportBoardFormDto);
            reportService.save(reportBoardFormDto);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errorMessage","신고 등록 중 오류");
            return "/report/reportFalse";
        }
        return "report/reportSuccess";
    }


}
