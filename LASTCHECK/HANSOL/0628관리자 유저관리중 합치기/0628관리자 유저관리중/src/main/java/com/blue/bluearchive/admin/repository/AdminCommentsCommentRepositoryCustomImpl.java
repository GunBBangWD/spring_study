package com.blue.bluearchive.admin.repository;

import com.blue.bluearchive.admin.dto.AdminSearchDto;
import com.blue.bluearchive.board.entity.Comment;
import com.blue.bluearchive.board.entity.CommentsComment;
import com.blue.bluearchive.board.entity.QComment;
import com.blue.bluearchive.board.entity.QCommentsComment;
import com.blue.bluearchive.report.entity.QReport;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
@Slf4j
public class AdminCommentsCommentRepositoryCustomImpl implements AdminCommentsCommentRepositoryCustom {
    private JPAQueryFactory queryFactory;
    public AdminCommentsCommentRepositoryCustomImpl(EntityManager em){
        this.queryFactory=new JPAQueryFactory(em);
    }
    //검색 조건 맞은거 찾아냄
    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("commentsCommentContent",searchBy)){
            return QCommentsComment.commentsComment.commentsCommentContent.like("%"+searchQuery+"%");
        }else if(StringUtils.equals("createdBy",searchBy)) {
            return QCommentsComment.commentsComment.createdBy.like("%"+searchQuery+"%");
        }
        return null;
    }
//    @Override
//    public Page<CommentsComment> getCommentsCommentPage(AdminSearchDto commentSearchDto, Pageable pageable) {
//        List<CommentsComment> content=queryFactory
//                .selectFrom(QCommentsComment.commentsComment)
//                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
//                ).orderBy(QCommentsComment.commentsComment.commentsCommentId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch(); //전체 반환
//        long total = queryFactory.select(Wildcard.count).from(QCommentsComment.commentsComment)
//                .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
//                ).fetchOne();
//
//        return new PageImpl<>(content,pageable,total);
//    }
@Override
public Page<CommentsComment> getCommentsCommentPage(AdminSearchDto commentSearchDto, Pageable pageable) {
    BooleanBuilder builder = new BooleanBuilder();
// Report가 있는 경우, reportStatus가 false인 것만 포함
    builder.and(QReport.report.isNotNull().and(QReport.report.reportStatus.eq(false)));
// Report가 없는 경우도 포함
    builder.or(QReport.report.isNull());
    List<CommentsComment> content = queryFactory
            .selectFrom(QCommentsComment.commentsComment)
            .leftJoin(QReport.report).on(QCommentsComment.commentsComment.commentsCommentId.eq(QReport.report.commentsComment.commentsCommentId))
            .where(builder)
            .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery()))
            .groupBy(QCommentsComment.commentsComment.commentsCommentId)
            .orderBy(QReport.report.count().coalesce(0L).desc(), QCommentsComment.commentsComment.commentsCommentId.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

//
//    List<CommentsComment> content=queryFactory
//            .selectFrom(QCommentsComment.commentsComment)
//            .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
//            ).orderBy(QCommentsComment.commentsComment.commentsCommentId.desc())
//            .offset(pageable.getOffset()).limit(pageable.getPageSize())
//            .fetch(); //전체 반환
    long total = queryFactory.select(Wildcard.count).from(QCommentsComment.commentsComment)
            .where(searchByLike(commentSearchDto.getSearchBy(),commentSearchDto.getSearchQuery())
            ).fetchOne();

    return new PageImpl<>(content,pageable,total);
}
//    public Page<CommentsComment> getBoardCommentsCommentPage(int categoryId, AdminSearchDto commentSearchDto, Pageable pageable) {
//        log.info("Qcomment"+QCommentsComment.commentsComment.comment);
//        log.info("board"+QCommentsComment.commentsComment.comment.board);
//        log.info("category"+QCommentsComment.commentsComment.comment.board.category);
//        log.info("Qcomment"+QCommentsComment.commentsComment.comment.board.category.categoryId);
//        List<CommentsComment> content = queryFactory
//                .selectFrom(QCommentsComment.commentsComment)
//                .leftJoin(QCommentsComment.commentsComment.comment).fetchJoin()
//                .leftJoin(QCommentsComment.commentsComment.comment.board).fetchJoin()
//                .leftJoin(QCommentsComment.commentsComment.comment.board.category).fetchJoin()
//                .where(QCommentsComment.commentsComment.comment.board.category.categoryId.eq(categoryId)
//                        .and(searchByLike(commentSearchDto.getSearchBy(), commentSearchDto.getSearchQuery()))
//                ).orderBy(QCommentsComment.commentsComment.comment.board.boardId.desc())
//                .offset(pageable.getOffset()).limit(pageable.getPageSize())
//                .fetch();
//        long total = queryFactory.select(Wildcard.count).from(QCommentsComment.commentsComment)
//                .where(QCommentsComment.commentsComment.comment.board.category.categoryId.eq(categoryId)
//                        .and(searchByLike(commentSearchDto.getSearchBy(), commentSearchDto.getSearchQuery()))
//                ).fetchOne();
//
//        return new PageImpl<>(content, pageable, total);
//    }

}
