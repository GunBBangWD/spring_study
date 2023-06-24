package com.blue.bluearchive.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -511910231L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final com.blue.bluearchive.shop.entity.QBaseEntity _super = new com.blue.bluearchive.shop.entity.QBaseEntity(this);

    public final QBoard boardId;

    public final StringPath commentContent = createString("commentContent");

    public final NumberPath<Integer> commentHateCount = createNumber("commentHateCount", Integer.class);

    public final NumberPath<Integer> commentId = createNumber("commentId", Integer.class);

    public final NumberPath<Integer> commentLikeCount = createNumber("commentLikeCount", Integer.class);

    public final NumberPath<Integer> commentReportsCount = createNumber("commentReportsCount", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardId = inits.isInitialized("boardId") ? new QBoard(forProperty("boardId"), inits.get("boardId")) : null;
    }

}

