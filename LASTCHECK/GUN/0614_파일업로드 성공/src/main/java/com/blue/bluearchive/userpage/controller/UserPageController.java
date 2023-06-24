package com.blue.bluearchive.userpage.controller;


import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.admin.service.CategoryService;
import com.blue.bluearchive.board.dto.BoardDto;
import com.blue.bluearchive.board.dto.CommentDto;
import com.blue.bluearchive.board.dto.CommentsCommentDto;
import com.blue.bluearchive.board.service.CommentService;
import com.blue.bluearchive.member.dto.CustomUserDetails;
import com.blue.bluearchive.userpage.dto.UserPageCommentDto;
import com.blue.bluearchive.userpage.dto.UserPageCommentsCommentDto;
import com.blue.bluearchive.userpage.service.UserPageCommentService;
import com.blue.bluearchive.userpage.service.UserPageCommentsCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserPageController {
    private final UserPageCommentService userPageCommentService;
    private final UserPageCommentsCommentService userPageCommentsCommentService;
    private final CategoryService categoryService;

    private String getUserIdx(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;
        String  userIdx=Long.toString(userDetails.getIdx());
        return userIdx;
    }


    @GetMapping("/user/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user/mypage")
    public String myPage(){
        return "userPage/user";
    }
    @GetMapping("/user/informationChange")
    public String myInformationChange(){
        return "userPage/userChange";
    }
    @GetMapping("/user/writingRecord")
    public String boardWirteRecord(){
        return "userPage/userBoardLog";
    }

    @GetMapping(value = "/user/commentRecord")
    public String commentRecord(Model model){
        System.out.println("=============카테고리 전체 출력===============");
        String  userIdx=getUserIdx();

        List<UserPageCommentDto> commentList = userPageCommentService.getCommentByCreatedBy(userIdx);

        model.addAttribute("commentList", commentList);
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "userPage/userCommentLog";
    }

    @GetMapping(value = "/user/commentRecord/{categoryId}")
    public String commentRecordCategoryId(@PathVariable int categoryId, Model model){
        System.out.println("==============카테고리 번호 접근===========");
        String  userIdx=getUserIdx();

        List<UserPageCommentDto> commentList = userPageCommentService.getCommentByCreatedBy(userIdx,categoryId);
        System.out.println("================댓글 내역 확인용============");
        System.out.println(commentList);

        model.addAttribute("commentList", commentList);
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("selectCategoryId", categoryId);

        return "userPage/userCommentLog";
    }


    @GetMapping("/user/commentsCommentRecord")
    public String commentsCommentRecord(Model model){
        System.out.println("=============대댓글 카테고리 전체 출력===============");
        String  userIdx=getUserIdx();


        List<UserPageCommentsCommentDto> commentsCommentList = userPageCommentsCommentService.getCommentsCommentByCreatedBy(userIdx);
        System.out.println("================댓글 내역 확인용============");
        System.out.println(commentsCommentList);
        model.addAttribute("commentsCommentList", commentsCommentList);


        List<CategoryDto> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);


        return "userPage/userCommentsCommentLog";
    }



}
