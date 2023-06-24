package com.blue.bluearchive.shop.controller;

import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.member.service.MemberService;
import com.blue.bluearchive.shop.dto.ItemFormDto;
import com.blue.bluearchive.shop.dto.ItemSearchDto;
import com.blue.bluearchive.shop.entity.Item;
import com.blue.bluearchive.shop.service.ItemService;
import com.blue.bluearchive.shop_inquiry.entity.Inquiry;
import com.blue.bluearchive.shop_inquiry.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    private final MemberRepository memberRepository;
    private final MemberService memberService;
	private final InquiryService inquiryService;

    @GetMapping(value = "/member/item/new")
    public String itemForm(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "/item/itemForm";
    }

    @PostMapping(value = "/member/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult
            , Model model
            , @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
        if (bindingResult.hasErrors()) {
            return "item/itemForm";
        }
        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage"
                    , "첫번째 상품 이미지는 필수 입력 값입니다.");
            return "item/itemForm";
        }
        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage"
                    , "상품 등록 중 에러가 발생했습니다.");
            return "item/itemForm";
        }
        return "redirect:/";
    }


    @GetMapping(value = "/member/item/{itemId}")
    public String itemDtl(@PathVariable("itemId") Long itemId, Model model) {
        try {
            ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
            model.addAttribute("itemFormDto", itemFormDto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다.");
            // 이게 안넘어가면 아예 파싱이 안됨!! 매우 중요
            model.addAttribute("itemFormDto", new ItemFormDto());
            return "item/itemForm";
        }
        return "item/itemForm";
    }

    @PostMapping(value = "/member/item/{itemId}")
    public String itemUpdate(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                             @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList, Model model) {

        if (bindingResult.hasErrors()) {
            return "item/itemForm";
        }
        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage"
                    ,"첫번째 상품 이미지 는 필수 입력 값입니다.");
            return "item/itemForm";
        }
        try {
            itemService.updateItem(itemFormDto, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생했습니다.");
            return "item/itemForm";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/member/itemDel/{itemId}")
    public String deleteItem(@PathVariable("itemId") Long itemId, Model model) {
        try {
            itemService.deleteItem(itemId);
        } catch (Exception e) {
            log.info("에러 처리");
            model.addAttribute("errorMessage", "상품 삭제 중 에러가 발생했습니다.");
//            return "item/itemForm";
            return "redirect:/";
        }
        return "redirect:/";
    }



    @GetMapping(value = {"/member/items", "/member/items/{page}"})
    public String itemManage(ItemSearchDto itemSearchDto,
                             @PathVariable("page") Optional<Integer> page,
                             Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
        Page<Item> items = itemService.getAdminItemPage(itemSearchDto, pageable);


        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);


        return "item/itemMng";
    }

    @GetMapping(value = "/item/{itemId}")
    public String itemDtl(Model model, @PathVariable("itemId") Long itemId)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Member member = memberRepository.findByEmail(email);

        String grade = (member != null && member.getGrade() != null) ? member.getGrade().toString() : "GRADE_BRONZE"; // 비회원은 BRONZE로 예외 처리
        model.addAttribute("grade", grade);

        ItemFormDto itemFormDto = itemService.getItemDtl(itemId);

        model.addAttribute("item", itemFormDto);
		List<Inquiry> inquiryList = inquiryService.getInquiryListByItemId(itemId);
        model.addAttribute("inquiryList", inquiryList); // inquiryList를 모델에 추가

        return "item/itemDtl";
    }
}
