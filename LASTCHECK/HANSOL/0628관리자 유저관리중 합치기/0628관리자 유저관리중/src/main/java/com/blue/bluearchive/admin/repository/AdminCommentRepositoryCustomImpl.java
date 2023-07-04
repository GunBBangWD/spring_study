package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.admin.dto.AdminSearchDto;
import com.blue.bluearchive.board.entity.Board;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.QBoard;
import com.blue.bluearchive.board.entity.QComment;
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

public class AdminCommentRepositoryCustomImpl implements AdminCommentRepositoryCustom {
    private JPAQueryFactory queryFactory;
    public AdminCommentRepositoryCustomImpl(EntityManager em){
        this.queryFactory=new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("commentContent",searchBy)){
            return QComment.comment.commentContent.like("%"+searchQuery+"%");
        }else if(StringUtils.equals("createdBy",searchBy)) {
            return QComment.comment.createdBy.like("%"+searchQuery+"%");
        }
        return null;
    }
    @Override
    public Page<Comment> getCommentPage(AdminSearchDto commentSearchDto, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
// Report가 있는 경우, reportStatus가 false인 것만 포함
        builder.and(QReport.report.isNotNull().and(QReport.report.reportStatus.eq(false)));
// Report가 없는 경우도 포함
        builder.or(QReport.report.isNull());
        List<Comment> content = queryFactory
                .selectFrom(QComment.comment)
                .leftJoin(QReport.report).on(QComment.comment.commentId.eq(QReport.report.comment.commentId))
                .where(builder)
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
                .groupBy(QComment.comment.commentId)
                .orderBy(QReport.report.count().coalesce(0L).desc(), QComment.comment.commentId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


//        List<Comment> content=queryFactory
//                .selectFrom(QComment.comment)
//                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
//                ).orderBy(QComment.comment.commentId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch();
        long total = queryFactory.select(Wildcard.count).from(QComment.comment)
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
                ).fetchOne();

        return new PageImpl<>(content,pageable,total);
    }

    @Override
    public Page<Comment> getBoardCommentPage(int categoryId, AdminSearchDto commentSearchDto, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
// Report가 있는 경우, reportStatus가 false인 것만 포함
        builder.and(QReport.report.isNotNull().and(QReport.report.reportStatus.eq(false)));
// Report가 없는 경우도 포함
        builder.or(QReport.report.isNull());
        List<Comment> content = queryFactory
                .selectFrom(QComment.comment)
                .leftJoin(QReport.report).on(QComment.comment.commentId.eq(QReport.report.comment.commentId))
                .where(builder)
                .where(QComment.comment.board.category.categoryId.eq(categoryId))
                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
                .groupBy(QComment.comment.commentId)
                .orderBy(QReport.report.count().coalesce(0L).desc(), QComment.comment.commentId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


//        List<Comment> content=queryFactory
//                .selectFrom(QComment.comment)
//                .where(QComment.comment.board.category.categoryId.eq(categoryId)
//                        .and(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
//                ).orderBy(QComment.comment.board.boardId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch();
        long total = queryFactory.select(Wildcard.count).from(QComment.comment)
                .where(QComment.comment.board.category.categoryId.eq(categoryId)
                        .and(searchByLike(commentSearchDto.getSearchBy(), commentSearchDto.getSearchQuery()))
                ).fetchOne();

        return new PageImpl<>(content,pageable,total);
    }

}
