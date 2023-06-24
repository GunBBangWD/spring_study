package com.blue.bluearchive.report.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReportBoard is a Querydsl query type for ReportBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReportBoard extends EntityPathBase<ReportBoard> {

    private static final long serialVersionUID = -1483056108L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReportBoard reportBoard = new QReportBoard("reportBoard");

    public final com.blue.bluearchive.shop.entity.QBaseEntity _super = new com.blue.bluearchive.shop.entity.QBaseEntity(this);

    public final StringPath boardCreatedBy = createString("boardCreatedBy");

    public final com.blue.bluearchive.board.entity.QBoard boardId;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final StringPath reportBoardCategory = createString("reportBoardCategory");

    public final StringPath reportBoardContent = createString("reportBoardContent");

    public final NumberPath<Integer> reportId = createNumber("reportId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QReportBoard(String variable) {
        this(ReportBoard.class, forVariable(variable), INITS);
    }

    public QReportBoard(Path<? extends ReportBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReportBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReportBoard(PathMetadata metadata, PathInits inits) {
        this(ReportBoard.class, metadata, inits);
    }

    public QReportBoard(Class<? extends ReportBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardId = inits.isInitialized("boardId") ? new com.blue.bluearchive.board.entity.QBoard(forProperty("boardId"), inits.get("boardId")) : null;
    }

}

