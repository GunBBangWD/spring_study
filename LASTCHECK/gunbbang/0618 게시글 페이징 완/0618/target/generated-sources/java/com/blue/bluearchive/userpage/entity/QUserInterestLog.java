package com.blue.bluearchive.userpage.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInterestLog is a Querydsl query type for UserInterestLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInterestLog extends EntityPathBase<UserInterestLog> {

    private static final long serialVersionUID = -210230069L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserInterestLog userInterestLog = new QUserInterestLog("userInterestLog");

    public final com.blue.bluearchive.admin.entity.QCategory category;

    public final NumberPath<Integer> categoryCount = createNumber("categoryCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> logTime = createDateTime("logTime", java.time.LocalDateTime.class);

    public final com.blue.bluearchive.member.entity.QMember member;

    public final NumberPath<Integer> userCategoryLogId = createNumber("userCategoryLogId", Integer.class);

    public QUserInterestLog(String variable) {
        this(UserInterestLog.class, forVariable(variable), INITS);
    }

    public QUserInterestLog(Path<? extends UserInterestLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserInterestLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserInterestLog(PathMetadata metadata, PathInits inits) {
        this(UserInterestLog.class, metadata, inits);
    }

    public QUserInterestLog(Class<? extends UserInterestLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.blue.bluearchive.admin.entity.QCategory(forProperty("category")) : null;
        this.member = inits.isInitialized("member") ? new com.blue.bluearchive.member.entity.QMember(forProperty("member")) : null;
    }

}

