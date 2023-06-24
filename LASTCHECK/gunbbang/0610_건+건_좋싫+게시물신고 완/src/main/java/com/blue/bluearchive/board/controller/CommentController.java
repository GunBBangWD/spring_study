package com.blue.bluearchive.board.controller;


import com.blue.bluearchive.admin.service.CategoryService;
import com.blue.bluearchive.board.dto.CommentFormDto;
import com.blue.bluearchive.board.dto.CommentsCommentFormDto;
import com.blue.bluearchive.board.service.BoardService;
import com.blue.bluearchive.board.service.CommentService;
import com.blue.bluearchive.board.service.CommentsCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


//전체 건희 추가
@Controller
@RequiredArgsConstructor
public class CommentController {
    private final BoardService boardService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final CommentsCommentService commentsCommentService;

    @PostMapping(value = "/comment/new")
    public String commentNew(@Valid CommentFormDto commentFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("================================댓글 유효성 추가 예정==============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
            System.out.println("엥");
            return "/board/boardWrite2";
        }
        try {
            commentService.save(commentFormDto);
        }catch (Exception e){
            System.out.println("================================댓글 작성중 오류===============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
        }
        return "redirect:/board/Detail/"+commentFormDto.getBoardId().getBoardId();
    }



    @PostMapping("/comment/edit")
    public String Commentedit(@RequestParam("boardId") int boardId,@RequestParam("commentId") int commentId, @RequestParam("commentContent") String commentContent, Model model) {
        //작성내용이 없을경우 예외처리
        System.out.println("수정 진입");
        if(commentContent == null || commentContent.trim().isEmpty()) {
            throw new IllegalArgumentException("작성된 내용이 없습니다");
        }
        commentService.update(commentId,commentContent);
        return "redirect:/board/Detail/" + boardId;
    }

    @PostMapping(value = "/comment/delete")
    public String commentDelete(@RequestParam("boardId") int boardId, @RequestParam("commentId") int commentId, Model model){
        commentService.delete(commentId);
        return "redirect:/board/Detail/"+boardId;
    }




    @PostMapping(value = "/commentsComment/new")
    public String commentsCommentNew(@Valid CommentsCommentFormDto commentsCommentFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("================================대댓글 유효성 추가 예정==============================");
            model.addAttribute("errorMessage","게시글 등록 중 오류");
            System.out.println("엥");
            return "/board/boardWrite2";
        }
        try {
            commentsCommentService.save(commentsCommentFormDto);
        }catch (Exception e){
            System.out.println("================================대댓글 작성중 오류===============================");
            e.printStackTrace();
            model.addAttribute("errorMessage","게시글 등록 중 오류");
        }

        return "redirect:/board/Detail/"+commentsCommentFormDto.getComment().getBoardId().getBoardId();
    }

    @PostMapping("/commentsComment/edit")
    public String commentsCommentEdit(@RequestParam("boardId") int boardId,@RequestParam("commentsCommentId") int commentsCommentId, @RequestParam("commentsCommentContent") String commentsCommentContent, Model model) {
        //작성내용이 없을경우 예외처리
        System.out.println("================================대댓글 수정 진입===============================");
        if(commentsCommentContent == null || commentsCommentContent.trim().isEmpty()) {
            throw new IllegalArgumentException("작성 내용이 없습니다");
        }

        commentsCommentService.update(commentsCommentId,commentsCommentContent);
        return "redirect:/board/Detail/" + boardId;
    }

    @PostMapping(value = "/commentsComment/delete")
    public String commentsCommentDelete(@RequestParam("boardId") int boardId, @RequestParam("commentsCommentId") int commentsCommentId, Model model){
        commentsCommentService.delete(commentsCommentId);
        return "redirect:/board/Detail/"+boardId;
    }

}
