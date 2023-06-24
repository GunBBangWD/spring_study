package com.blue.bluearchive.admin.service;

import com.blue.bluearchive.admin.dto.ReportDto;
import com.blue.bluearchive.admin.dto.ReportPageDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.repository.BoardRepository;
import com.blue.bluearchive.board.repository.CommentRepository;
import com.blue.bluearchive.board.repository.CommentsCommentRepository;
import com.blue.bluearchive.report.entity.Report;
import com.blue.bluearchive.report.repository.ReportBoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminReportService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentsCommentRepository commentsCommentRepository;
    private final ReportBoardRepository reportBoardRepository;

    //승훈 추가
    ModelMapper modelMapper = new ModelMapper();
    public ReportPageDto getReportsForBoard(int boardId, int page, int pageSize) {
        Optional<Board> board = boardRepository.findById(boardId);
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("regTime").descending());
        Page<Report> reportPage = reportBoardRepository.findByBoardAndReportStatusOrderByRegTimeDesc(board.get(), false, pageable);
        List<ReportDto> reportDtoList = reportPage.map(report -> modelMapper.map(report, ReportDto.class)).getContent();

        ReportPageDto reportPageDto = new ReportPageDto();
        reportPageDto.setReportList(reportDtoList);
        reportPageDto.setCurrentPage(reportPage.getNumber() + 1);
        reportPageDto.setTotalPages(reportPage.getTotalPages());

        return reportPageDto;
    }
    //페이징 처리
    public ReportPageDto getReportsForComment(int commentId,int page, int pageSize) {
        Optional<Comment> commentsComment = commentRepository.findById(commentId);
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("regTime").descending());
        Page<Report> reportPage = reportBoardRepository.findByCommentAndReportStatusOrderByRegTimeDesc(commentsComment.get(), false, pageable);
        List<ReportDto> reportDtoList = reportPage.map(report -> modelMapper.map(report, ReportDto.class)).getContent();

        ReportPageDto reportPageDto = new ReportPageDto();
        reportPageDto.setReportList(reportDtoList);
        reportPageDto.setCurrentPage(reportPage.getNumber() + 1);
        reportPageDto.setTotalPages(reportPage.getTotalPages());

        return reportPageDto;
    }
    public ReportPageDto getReportsForCommentsComment(int commentsCommentId, int page, int pageSize) {
        Optional<CommentsComment> commentsComment = commentsCommentRepository.findById(commentsCommentId);
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("regTime").descending());
        Page<Report> reportPage = reportBoardRepository.findByCommentsCommentAndReportStatusOrderByRegTimeDesc(commentsComment.get(), false, pageable);
        List<ReportDto> reportDtoList = reportPage.map(report -> modelMapper.map(report, ReportDto.class)).getContent();

        ReportPageDto reportPageDto = new ReportPageDto();
        reportPageDto.setReportList(reportDtoList);
        reportPageDto.setCurrentPage(reportPage.getNumber() + 1);
        reportPageDto.setTotalPages(reportPage.getTotalPages());

        return reportPageDto;
    }
    //    @Transactional
//    public void confirmReports(List<Integer> reportIds) {
//        List<Report> reports = reportBoardRepository.findAllById(reportIds);
//
//        for (Report report : reports) {
//            report.setReportStatus(true); // 읽음 상태로 설정
//        }
//
//        reportBoardRepository.saveAll(reports);
//    }
    @Transactional
    public int confirmReports(List<Integer> reportIds) {
        List<Report> reports = reportBoardRepository.findAllById(reportIds);

        for (Report report : reports) {
            report.setReportStatus(true); // 읽음 상태로 설정
        }

        reportBoardRepository.saveAll(reports);

        return reports.size();
    }
}
