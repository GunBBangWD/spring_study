package com.blue.bluearchive.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1442510941L;

    public static final QCategory category = new QCategory("category");

    public final ListPath<com.blue.bluearchive.board.entity.Board, com.blue.bluearchive.board.entity.QBoard> board = this.<com.blue.bluearchive.board.entity.Board, com.blue.bluearchive.board.entity.QBoard>createList("board", com.blue.bluearchive.board.entity.Board.class, com.blue.bluearchive.board.entity.QBoard.class, PathInits.DIRECT2);

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    public final StringPath categoryName = createString("categoryName");

    public final ListPath<com.blue.bluearchive.userpage.entity.UserInterestCount, com.blue.bluearchive.userpage.entity.QUserInterestCount> userInterestCount = this.<com.blue.bluearchive.userpage.entity.UserInterestCount, com.blue.bluearchive.userpage.entity.QUserInterestCount>createList("userInterestCount", com.blue.bluearchive.userpage.entity.UserInterestCount.class, com.blue.bluearchive.userpage.entity.QUserInterestCount.class, PathInits.DIRECT2);

    public final ListPath<com.blue.bluearchive.userpage.entity.UserInterestLog, com.blue.bluearchive.userpage.entity.QUserInterestLog> userInterestLog = this.<com.blue.bluearchive.userpage.entity.UserInterestLog, com.blue.bluearchive.userpage.entity.QUserInterestLog>createList("userInterestLog", com.blue.bluearchive.userpage.entity.UserInterestLog.class, com.blue.bluearchive.userpage.entity.QUserInterestLog.class, PathInits.DIRECT2);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

