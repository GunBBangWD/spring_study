package com.blue.bluearchive.board.controller;

import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.board.dto.*;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.board.service.BoardService;
import com.blue.bluearchive.admin.service.CategoryService;
import com.blue.bluearchive.board.service.CommentService;
import com.blue.bluearchive.board.service.CommentsCommentService;
import com.blue.bluearchive.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final CommentsCommentService commentsCommentService;
    private final MemberRepository memberRepository;

    @GetMapping(value = "/board/all")
    public String getBoardList(Model model) {
        List<BoardDto> boardList = boardService.getAllBoards();
        model.addAttribute("boardList", boardList);



        List<CategoryDto> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "board/list";
    }


    // POST 방식으로 "/board/{categoryId}" 경로에 접근할 때의 처리
    @GetMapping(value = "/board/{categoryId}")
    public String getBoardsByCategory(@PathVariable int categoryId, Model model) {
        Category category = categoryService.getCategoryById(categoryId); // categoryId에 해당하는 카테고리를 가져옵니다.
        List<BoardDto> boardList = boardService.getBoardsByCategory(category); // 해당 카테고리에 속한 게시물들을 가져옵니다.
        model.addAttribute("boardList", boardList); // boardList를 모델에 추가합니다.


        List<CategoryDto> categoryList = categoryService.getAllCategory(); // 모든 카테고리를 가져옵니다.
        model.addAttribute("categoryList", categoryList); // categoryList를 모델에 추가합니다.


        return "board/list"; // board/list 뷰를 반환합니다.
    }
    @GetMapping("/board/Detail/{boardId}")
    public String getBoardDetails(@PathVariable int boardId, Model model) {
        boardService.incrementBoardCount(boardId);
        BoardDto board = boardService.getBoardById(boardId);

        System.out.println("================================"+board.getRegTime()+"=====================================");

        List<CategoryDto> categoryList = categoryService.getAllCategory(); // 모든 카테고리를 가져옵니다.
        model.addAttribute("categoryList", categoryList); // categoryList를 모델에 추가합니다.

        model.addAttribute("board", board);
        List<CommentDto> commentList = commentService.getCommentByBoardId(boardId);
        model.addAttribute("commentList", commentList);
        Map<Integer, List<CommentsCommentDto>> commentsCommentMap = new HashMap<>();
        for (CommentDto comment : commentList) {
            int commentId = comment.getCommentId();
            List<CommentsCommentDto> commentsCommentList = commentsCommentService.getCommentsCommentByCommentId(commentId);
            if(!commentsCommentList.isEmpty()) commentsCommentMap.put(commentId, commentsCommentList);
        }
        model.addAttribute("commentsCommentMap", commentsCommentMap);

        return "board/boardDetail_HAN";
    }
    @GetMapping(value = "/board/Write/new")
    public String getBoardWrite(Model model){
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("BoardFormDto",new BoardFormDto());
        return "board/boardWrite2";
    }
    @PostMapping(value = "/board/Write/new")
    public String boardNew(@Valid BoardFormDto boardFormDto, BindingResult bindingResult, Model model){
        System.out.println("================================엥===============================");
        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage","게시글 등록 중 오류");
            System.out.println("엥");
            return "/board/boardWrite2";
        }
        try {
            boardService.saveBoard(boardFormDto);
        }catch (Exception e){
            model.addAttribute("errorMessage","게시글 등록 중 오류");
        }
        return "redirect:/board/"+boardFormDto.getCategory().getCategoryId();
    }
    @PostMapping("/board/Wirte/upload")
    public String uploadFiles(@RequestPart("files") MultipartFile[] files) {
        // 파일 업로드 처리
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                return "Failed to upload files";
            }
        }

        // 업로드 성공 메시지 반환
        return "Files uploaded successfully";
    }
}
