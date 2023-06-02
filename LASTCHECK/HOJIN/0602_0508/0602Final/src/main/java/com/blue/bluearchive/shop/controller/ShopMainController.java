package com.blue.bluearchive.shop.controller;

import com.blue.bluearchive.shop.dto.ItemSearchDto;
import com.blue.bluearchive.shop.dto.MainItemDto;
import com.blue.bluearchive.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopMainController {

    private final ItemService itemService;

    @GetMapping(value = "/main")
   	public String shopMain(HttpServletRequest request, ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

//        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute("name");
//        model.addAttribute("name", name);
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(">>>>>>>>>" + auth);

        Pageable pageable = PageRequest.of(page.isPresent()?page.get():0,6);
        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto,pageable);

        model.addAttribute("items",items);
        model.addAttribute("itemSearchDto",itemSearchDto);
        model.addAttribute("maxPage",5);
        return "shopMain";
    }
}