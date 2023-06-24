package com.blue.bluearchive.board.controller;


import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.admin.service.CategoryService;
import com.blue.bluearchive.board.dto.*;
import com.blue.bluearchive.board.service.BoardService;
import com.blue.bluearchive.board.service.CommentService;
import com.blue.bluearchive.board.service.CommentsCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//전체 건희 추가
@Controller
@RequiredArgsConstructor
public class CommentController {
    private final BoardService boardService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final CommentsCommentService commentsCommentService;

    @PostMapping(value = "/comment/new")
    public String boardNew(@Valid CommentFormDto commentFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("================================댓글 유효성 추가 예정==============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
            System.out.println("엥");
            return "/board/boardWrite2";
        }
        try {
            commentService.saveBoard(commentFormDto);
        }catch (Exception e){
            System.out.println("================================댓글 작성중 오류===============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
        }

        return "redirect:/board/Detail/"+commentFormDto.getBoardId().getBoardId();
    }


    @PostMapping(value = "/commentsComment/new")
    public String boardNew(@Valid CommentsCommentFormDto commentsCommentFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("================================대댓글 유효성 추가 예정==============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
            System.out.println("엥");
            return "/board/boardWrite2";
        }
        try {
            commentsCommentService.saveBoard(commentsCommentFormDto);
        }catch (Exception e){
            System.out.println("================================댓글 작성중 오류===============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
        }

        return "redirect:/board/Detail/"+commentsCommentFormDto.getComment().getBoardId().getBoardId();
    }

}
