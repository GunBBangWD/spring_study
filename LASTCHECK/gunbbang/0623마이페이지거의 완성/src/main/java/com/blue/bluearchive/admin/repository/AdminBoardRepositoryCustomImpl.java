package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.admin.dto.AdminSearchDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.QBoard;
import com.blue.bluearchive.report.entity.QReport;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminBoardRepositoryCustomImpl implements AdminBoardRepositoryCustom {
    private JPAQueryFactory queryFactory;
    public AdminBoardRepositoryCustomImpl(EntityManager em){
        this.queryFactory=new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("boardTitle",searchBy)){
            return QBoard.board.boardTitle.like("%"+searchQuery+"%");
        }else if(StringUtils.equals("createdBy",searchBy)) {
            return QBoard.board.createdBy.like("%"+searchQuery+"%");
        }
        return null;
    }
    @Override
    public Page<Board> getBoardPage(AdminSearchDto commentSearchDto, Pageable pageable) {
        System.out.println("getBoardPage==="+commentSearchDto);
        BooleanBuilder builder = new BooleanBuilder();
// Report가 있는 경우, reportStatus가 false인 것만 포함
        builder.and(QReport.report.isNotNull().and(QReport.report.reportStatus.eq(false)));
// Report가 없는 경우도 포함
        builder.or(QReport.report.isNull());
        List<Board> content = queryFactory
                .selectFrom(QBoard.board)
                .leftJoin(QReport.report).on(QBoard.board.boardId.eq(QReport.report.board.boardId))
                .where(builder)
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
                .groupBy(QBoard.board.boardId)
                .orderBy(QReport.report.count().coalesce(0L).desc(), QBoard.board.boardId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

//        List<Board> content=queryFactory
//                .selectFrom(QBoard.board)
//                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
//                ).orderBy(QBoard.board.boardId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch();

        long total = queryFactory.select(Wildcard.count).from(QBoard.board)
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
                ).fetchOne();

        System.out.println("=====확인용===="+total);
        System.out.println("========="+content.size());
        System.out.println("========="+pageable.getOffset());
        return new PageImpl<>(content,pageable,total);
    }

    @Override
    public Page<Board> getCategoryBoardPage(int categoryId, AdminSearchDto commentSearchDto, Pageable pageable) {
        System.out.println("getCategoryBoardPage==="+commentSearchDto);
        BooleanBuilder builder = new BooleanBuilder();
// Report가 있는 경우, reportStatus가 false인 것만 포함
        builder.and(QReport.report.isNotNull().and(QReport.report.reportStatus.eq(false)));
// Report가 없는 경우도 포함
        builder.or(QReport.report.isNull());
        List<Board> content = queryFactory
                .selectFrom(QBoard.board)
                .leftJoin(QReport.report).on(QBoard.board.boardId.eq(QReport.report.board.boardId))
                .where(builder)
                .where(QBoard.board.category.categoryId.eq(categoryId))
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
                .groupBy(QBoard.board.boardId)
                .orderBy(QReport.report.count().coalesce(0L).desc(), QBoard.board.boardId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();




//        List<Board> content=queryFactory
//                .selectFrom(QBoard.board)
//                .where(QBoard.board.category.categoryId.eq(categoryId)
//                        .and(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
//                ).orderBy(QBoard.board.boardId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch();
        long total = queryFactory.select(Wildcard.count).from(QBoard.board)
                .where(QBoard.board.category.categoryId.eq(categoryId)
                        .and(searchByLike(commentSearchDto.getSearchBy(), commentSearchDto.getSearchQuery()))
                ).fetchOne();

        return new PageImpl<>(content,pageable,total);
    }

}
