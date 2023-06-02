package com.blue.bluearchive.shop_inquiry.controller;

import com.blue.bluearchive.shop_inquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/item/inquiry")
public class InquiryController {

    private final InquiryService inquiryService;

    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping("/{itemId}")
    public String submitInquiry(@PathVariable("itemId") Long itemId, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String email = request.getParameter("createdBy");
        String content = request.getParameter("inquiryContent");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + email + content);

        if (content == null) {
            redirectAttributes.addFlashAttribute("error", "문의 내용을 입력해주세요.");
            return "redirect:/item/" + itemId;
        }

        inquiryService.inquiryWrite(itemId, email, content);

        redirectAttributes.addFlashAttribute("message", "문의가 성공적으로 등록되었습니다.");

        // 적절한 리다이렉트 경로를 반환하세요.
        return "redirect:/item/" + itemId;
    }
    @DeleteMapping("/{inquiryId}")
    public String deleteInquiry(@PathVariable("inquiryId") Long inquiryId) {
        inquiryService.inquiryDelete(inquiryId);
        return "redirect:"; // 적절한 아이템 페이지의 URL을 반환합니다.
    }

}
