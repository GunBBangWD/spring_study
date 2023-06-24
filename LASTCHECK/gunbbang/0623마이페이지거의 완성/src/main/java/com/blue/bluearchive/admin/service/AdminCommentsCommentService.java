package com.blue.bluearchive.admin.service;


import com.blue.bluearchive.admin.dto.AdminCommentsCommentDto;
import com.blue.bluearchive.admin.dto.AdminSearchDto;
import com.blue.bluearchive.admin.repository.AdminBoardRepository;
import com.blue.bluearchive.admin.repository.AdminCommentsCommentRepository;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.report.repository.ReportBoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCommentsCommentService {
    private final AdminCommentsCommentRepository adminCommentsCommentRepository;
    private final AdminBoardRepository adminBoardRepository;
    private final ReportBoardRepository reportBoardRepository;
    private final CommentsCommentRepository commentsCommentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

        private Page<AdminCommentsCommentDto> getComment(Page<CommentsComment> comments) {
        List<AdminCommentsCommentDto> commentsCommentDtos = new ArrayList<>();
        for (CommentsComment commentsComment : comments.getContent()) {
            commentsCommentDtos.add(modelMapper.map(commentsComment, AdminCommentsCommentDto.class));
            int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
            System.out.println("getComment" + size);
            commentsCommentDtos.get(commentsCommentDtos.size()-1).setNotReportCount(size);
        }
        long total = comments.getTotalElements();
        return new PageImpl<>(commentsCommentDtos, comments.getPageable(), total);
    }

    @Transactional(readOnly = true)
    public Page<AdminCommentsCommentDto> getCommentByCreatedBy(int categoryId, AdminSearchDto searchDto, Pageable pageable){
        Page<AdminCommentsCommentDto> adminCommentDtoPage;
        Page<CommentsComment> boardCommentPage;
        if(categoryId==0){
           boardCommentPage = adminCommentsCommentRepository.getCommentsCommentPage(searchDto, pageable);
           adminCommentDtoPage = getComment(boardCommentPage);
        }else {
            System.out.println("id=======================실행전" + categoryId);
            List<CommentsComment> commentsCommentList = adminCommentsCommentRepository.findAll();
            List<AdminCommentsCommentDto> commentsCommentDtos = new ArrayList<>();
            for (CommentsComment commentsComment : commentsCommentList) {
                if (commentsComment.getComment().getBoard().getCategory() != null
                        && commentsComment.getComment().getBoard().getCategory().getCategoryId() == categoryId
                        && searchByLike(searchDto, commentsComment)) {
                    int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
                    System.out.println("size========="+size);
                    AdminCommentsCommentDto commentsCommentDto = modelMapper.map(commentsComment, AdminCommentsCommentDto.class);
                    commentsCommentDto.setNotReportCount(size);
                    commentsCommentDtos.add(commentsCommentDto);
                }
            }
            long total = Long.valueOf(commentsCommentDtos.size());
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), commentsCommentDtos.size());
            List<AdminCommentsCommentDto> commentDtos = commentsCommentDtos.subList(start, end);

            adminCommentDtoPage = new PageImpl<>(commentDtos, pageable, total);
        }
        return adminCommentDtoPage;
    }
    private boolean searchByLike(AdminSearchDto searchDto, CommentsComment commentsComment) {
        String searchBy = searchDto.getSearchBy();
        String searchQuery = searchDto.getSearchQuery();

        if (searchBy != null && searchQuery != null) {
            if (searchBy.equals("createdBy")) {
                return commentsComment.getComment().getCreatedBy().contains(searchQuery);
            } else if (searchBy.equals("commentsCommentContent")) {
                return commentsComment.getCommentsCommentContent().contains(searchQuery);
            }
        }

        return true; // 검색 조건이 없거나 지원하지 않는 검색 조건인 경우 모든 댓글을 가져옵니다.
    }


    //승훈 코드 추가
    private final BoardRepository boardRepository;
    public List<AdminCommentsCommentDto> getCommentsCommentByCategoryId(int categoryId) {
        List<AdminCommentsCommentDto> commentsCommentDtos = new ArrayList<>();

        if(categoryId == 0){
            List<Board> boards = boardRepository.findAll();

            for (Board board : boards) {
                List<CommentsComment> commentsComments = adminCommentsCommentRepository.findByComment_Board(board);
                for (CommentsComment commentsComment : commentsComments) {
                    AdminCommentsCommentDto commentsCommentDtoDto = modelMapper.map(commentsComment, AdminCommentsCommentDto.class);
                    commentsCommentDtos.add(commentsCommentDtoDto);
                    int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
                    commentsCommentDtos.get(commentsCommentDtos.size()-1).setNotReportCount(size);
                }
            }
        }else{
            List<Board> boards = adminBoardRepository.findByCategoryCategoryId(categoryId);

            for (Board board : boards) {
                List<CommentsComment> comments = adminCommentsCommentRepository.findByComment_Board(board);
                for (CommentsComment commentsComment : comments) {
                    AdminCommentsCommentDto commentsCommentDto = modelMapper.map(commentsComment, AdminCommentsCommentDto.class);
                    commentsCommentDtos.add(commentsCommentDto);
                    int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
                    commentsCommentDtos.get(commentsCommentDtos.size()-1).setNotReportCount(size);
                }
            }
        }

        return commentsCommentDtos;
    }

    public List<AdminCommentsCommentDto> getCommentsComment() {
        List<AdminCommentsCommentDto> commentsCommentDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            List<CommentsComment> commentsComments = adminCommentsCommentRepository.findByComment_Board(board);
            for (CommentsComment commentsComment : commentsComments) {
                AdminCommentsCommentDto commentsCommentDto = modelMapper.map(commentsComment, AdminCommentsCommentDto.class);
                commentsCommentDtos.add(commentsCommentDto);
                int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
                commentsCommentDtos.get(commentsCommentDtos.size()-1).setNotReportCount(size);
            }
        }
        return commentsCommentDtos;
    }


    public void deletes(List<Integer> commentsCommentIds) {
        for (Integer commentsCommentId : commentsCommentIds) {
            // Retrieve the reply by its ID
            CommentsComment commentsComment = commentsCommentRepository.findById(commentsCommentId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid commentsCommentId: " + commentsCommentId));
            System.out.println(commentsComment.getCommentsCommentId()+"아이디아이디");
            commentsCommentRepository.deleteById(commentsComment.getCommentsCommentId());
        }
    }


    public List<AdminCommentsCommentDto> searchCommentsComment(String option, String keyword) {
        List<CommentsComment> commentsComments;
        List<AdminCommentsCommentDto> commentsCommentList = new ArrayList<>();

        switch (option) {
            case "1": // 작성자
                commentsComments = adminCommentsCommentRepository.findByCreatedByContaining(keyword);
                break;
            case "2": // 내용
                commentsComments = adminCommentsCommentRepository.findByCommentsCommentContentContaining(keyword);
                break;
            default:
                commentsComments = Collections.emptyList();
                break;
        }

        for (CommentsComment commentsComment : commentsComments) {
            commentsCommentList.add(modelMapper.map(commentsComment, AdminCommentsCommentDto.class));
            int size = reportBoardRepository.findByCommentsCommentCommentsCommentIdAndReportStatusFalse(commentsComment.getCommentsCommentId()).size();
            commentsCommentList.get(commentsCommentList.size()-1).setNotReportCount(size);
        }

        return commentsCommentList;
    }

}
