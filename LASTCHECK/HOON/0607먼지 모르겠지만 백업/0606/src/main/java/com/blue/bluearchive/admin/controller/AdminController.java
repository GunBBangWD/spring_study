package com.blue.bluearchive.admin.controller;

import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CategoryService categoryService;
    @GetMapping("/main")
    public String adminMain(){
        return "adminPage/manageMain";
    }
    @GetMapping("/userMgt")
    public String userMgt(){
        return "adminPage/manageUser";
    }
    @GetMapping("/shopMgt")
    public String shopMgt(){
        return "adminPage/manageShop";
    }
    @GetMapping("/sellUserMgt")
    public String sellUserMgt(){
        return "/adminPage/manageUserSell";
    }
    @GetMapping("/boardMgt")
    public String boardMgt(Model model)
    {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
        model.addAttribute("categoryList",categoryDtoList);
        return "/adminPage/manageCommunity_board";

    }
    @GetMapping("/commentMgt")
    public String commentMgt(){
        return "/adminPage/manageCommunity_comment";
    }
    @GetMapping("/newcategory")
    public String newCate(){
        return "adminPage/newCategory";
    }
    @GetMapping("/commMgt")
    public String commMgt(Model model){
        List<CategoryDto> list = categoryService.getAllCategory();
        model.addAttribute("catelist",list);
        return "adminPage/manageCommunity";
    }
@PostMapping("/createCate")
public String newCate(@ModelAttribute CategoryDto categoryDto) throws Exception {
    try {
        categoryService.save(categoryDto);
        return "redirect:/admin/commMgt";
    } catch (IllegalArgumentException e) {
        return "redirect:/admin/newcategory?duplicateError&categoryName=" + URLEncoder.encode(categoryDto.getCategoryName(), "UTF-8");
    }
}
    @GetMapping("delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        try {
            categoryService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/update/{id}")
    public String categoryUpdate(@PathVariable int id, Model model) {
        Category categoryDto = categoryService.getCategoryById(id);
        model.addAttribute("categoryDto", categoryDto);
        return "adminPage/categoryUpdate";
    }

@PostMapping("/updateCategory")
public String categoryUpdate(@ModelAttribute CategoryDto categoryDto) throws Exception {
    try {
        categoryService.update(categoryDto);
        return "redirect:/admin/commMgt";
    } catch (IllegalArgumentException e) {
        return "redirect:/admin/update/" + categoryDto.getCategoryId()
                +"?duplicateError&categoryName=" + URLEncoder.encode(categoryDto.getCategoryName(), "UTF-8");
    }
}
}