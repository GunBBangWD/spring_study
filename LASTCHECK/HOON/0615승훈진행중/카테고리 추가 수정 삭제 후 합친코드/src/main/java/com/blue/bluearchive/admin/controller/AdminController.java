package com.blue.bluearchive.admin.controller;

import com.blue.bluearchive.admin.dto.CategoryDto;
import com.blue.bluearchive.admin.entity.Category;
import com.blue.bluearchive.admin.service.CategoryService;
import com.blue.bluearchive.board.dto.BoardDto;
import com.blue.bluearchive.board.dto.CommentDto;
import com.blue.bluearchive.board.dto.CommentsCommentDto;
import com.blue.bluearchive.board.service.BoardService;
import com.blue.bluearchive.board.service.CommentService;
import com.blue.bluearchive.board.service.CommentsCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private final CategoryService categoryService;
    private final BoardService boardService;
    private final CommentService commentService;
    private final CommentsCommentService commentsCommentService;


    @GetMapping("/main")
    public String adminMain() {
        return "adminPage/manageMain";
    }

    @GetMapping("/userMgt")
    public String userMgt() {
        return "adminPage/manageUser";
    }

    @GetMapping("/shopMgt")
    public String shopMgt() {
        return "adminPage/manageShop";
    }

    @GetMapping("/sellUserMgt")
    public String sellUserMgt() {
        return "/adminPage/manageUserSell";
    }

@GetMapping("/boardMgt")
public String boardMgt(Model model, @RequestParam(value = "categoryId", defaultValue = "0") int categoryId) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
    List<BoardDto> boardDtoList;

    if (categoryId == 0) {
        // Fetch all boards
        boardDtoList = boardService.getAllBoards();
    } else {
        // Fetch boards by category ID
        boardDtoList = boardService.getBoardsByCategoryId(categoryId);
    }
    model.addAttribute("categoryList", categoryDtoList);
    model.addAttribute("boardDtoList", boardDtoList);
    return "/adminPage/manageCommunity_board"; // boardMgt.html 페이지를 렌더링하여 반환
}
    @GetMapping("/boardMgt2")
    public String boardMgt(Model model, @RequestParam(value = "search") String search,
                           @RequestParam(value = "keyword")String keyword) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();

        List<BoardDto> boardDtoList = boardService.searchBoards(search,keyword);
        if (boardDtoList.isEmpty()) {
            model.addAttribute("message", "해당 게시글이 존재하지 않습니다.");
        }
        model.addAttribute("categoryList", categoryDtoList);
        model.addAttribute("boardDtoList", boardDtoList);
        return "/adminPage/manageCommunity_board"; // boardMgt.html 페이지를 렌더링하여 반환
    }

//    @GetMapping("/commentMgt")
//    public String commentMgt(Model model) {
//        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
//        List<CommentDto> commentDtos = commentService.getComments();
//        model.addAttribute("commentDtos", commentDtos);
//        model.addAttribute("categoryList", categoryDtoList);
//        return "adminPage/manageCommunity_comment"; // boardMgt.html 페이지를 렌더링하여 반환
//    }
@GetMapping("/commentMgt")
public String getBoardsByCategoryId(@RequestParam int id,Model model) {
    List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
    model.addAttribute("categoryList", categoryDtoList);

    List<CommentDto> commentDtos = commentService.getCommentsByCategoryId(id);
    model.addAttribute("commentDtos", commentDtos);
    return "adminPage/manageCommunity_comment";  // Return as JSON
}
    @GetMapping("/commentsCommentMgt")
    public String getCommentsCommentMgt(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
        List<CommentsCommentDto> commentsCommentDtos = commentsCommentService.getCommentsComment();
        model.addAttribute("commentsCommentDtos", commentsCommentDtos);
        model.addAttribute("categoryList", categoryDtoList);
        return "adminPage/manageCommunity_commentsComment";  // Update the view template name
    }
    @GetMapping("/commentsCommentMgt/{id}")
    public String getCommentsCommentMgt(@PathVariable int id, Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
        List<CommentsCommentDto> commentsCommentDtos = commentsCommentService.getCommentsCommentByCategoryId(id);
        model.addAttribute("commentsCommentDtos", commentsCommentDtos);
        model.addAttribute("categoryList", categoryDtoList);
        return "adminPage/manageCommunity_commentsComment";  // Update the view template name
    }



    @GetMapping("/newcategory")
    public String newCate() {
        return "adminPage/newCategory";
    }

    @GetMapping("/commMgt")
    public String commMgt(Model model) {
        List<CategoryDto> categoryStatisticsList = categoryService.getTotal();
        model.addAttribute("categoryStatisticsList", categoryStatisticsList);
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
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
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
                    + "?duplicateError&categoryName=" + URLEncoder.encode(categoryDto.getCategoryName(), "UTF-8");
        }
    }

    @PostMapping("/deleteBoard")
    public ResponseEntity<?> deleteBoard(@RequestBody List<Integer> boardIds) {
        try {
            boardService.deleteBoards(boardIds);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/adminUpdate/{boardId}")
    public String boardCategoryUpdate(@PathVariable int boardId,Model model){
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
        String categoryName = boardService.getBoardById(boardId).getCategory().getCategoryName();
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("boardId", boardId);
        model.addAttribute("categoryList", categoryDtoList);
        return "adminPage/adminUpdateCategory";
    }
    @Transactional
    @GetMapping("/adminUpdate2/{updateCategory}/{boardId}")
    public String changeBoardCategoryName(@PathVariable int updateCategory, @PathVariable int boardId) {
        boardService.updateCategoryNameById(boardId, updateCategory);
        return "redirect:/admin/boardMgt"; // 원하는 리다이렉션 경로로 변경해주세요.
    }

}