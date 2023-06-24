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

    public final NumberPath<Integer> boardCount = createNumber("boardCount", Integer.class);

    public final ListPath<com.blue.bluearchive.board.entity.Board, com.blue.bluearchive.board.entity.QBoard> boards = this.<com.blue.bluearchive.board.entity.Board, com.blue.bluearchive.board.entity.QBoard>createList("boards", com.blue.bluearchive.board.entity.Board.class, com.blue.bluearchive.board.entity.QBoard.class, PathInits.DIRECT2);

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    public final StringPath categoryName = createString("categoryName");

    public final NumberPath<Integer> totalReports = createNumber("totalReports", Integer.class);

    public final NumberPath<Integer> totalViews = createNumber("totalViews", Integer.class);

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

