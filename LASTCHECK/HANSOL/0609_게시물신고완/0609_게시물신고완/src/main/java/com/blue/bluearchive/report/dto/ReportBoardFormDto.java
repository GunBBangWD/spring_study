package com.blue.bluearchive.report.dto;


import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.report.entity.ReportBoard;
import lombok.Data;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class ReportBoardFormDto {
    @NotBlank(message = "내용은 필수 입니다")
    private String reportBoardContent;
    @NotBlank(message = "카테고리 선택은 필수 입니다")
    private String reportBoardCategory;
    private String boardCreatedBy;
    private Board boardId;


    private static ModelMapper modelMapper = new ModelMapper();
    public ReportBoard createReport(){
        return modelMapper.map(this, ReportBoard.class);
    }

    public static ReportBoardFormDto of(ReportBoard reportBoard){
        return modelMapper.map(reportBoard, ReportBoardFormDto.class);
    }
}
