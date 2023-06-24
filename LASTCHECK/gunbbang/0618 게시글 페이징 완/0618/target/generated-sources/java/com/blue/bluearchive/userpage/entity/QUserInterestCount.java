package com.blue.bluearchive.userpage.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInterestCount is a Querydsl query type for UserInterestCount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInterestCount extends EntityPathBase<UserInterestCount> {

    private static final long serialVersionUID = -175928106L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserInterestCount userInterestCount = new QUserInterestCount("userInterestCount");

    public final com.blue.bluearchive.admin.entity.QCategory category;

    public final NumberPath<Integer> categoryAllCount = createNumber("categoryAllCount", Integer.class);

    public final NumberPath<Integer> categoryPreCount = createNumber("categoryPreCount", Integer.class);

    public final com.blue.bluearchive.member.entity.QMember member;

    public final NumberPath<Integer> userCategoryCountId = createNumber("userCategoryCountId", Integer.class);

    public QUserInterestCount(String variable) {
        this(UserInterestCount.class, forVariable(variable), INITS);
    }

    public QUserInterestCount(Path<? extends UserInterestCount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserInterestCount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserInterestCount(PathMetadata metadata, PathInits inits) {
        this(UserInterestCount.class, metadata, inits);
    }

    public QUserInterestCount(Class<? extends UserInterestCount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.blue.bluearchive.admin.entity.QCategory(forProperty("category")) : null;
        this.member = inits.isInitialized("member") ? new com.blue.bluearchive.member.entity.QMember(forProperty("member")) : null;
    }

}

