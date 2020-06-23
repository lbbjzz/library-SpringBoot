package com.zsc.javaee_booktest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReturnRecord is a Querydsl query type for ReturnRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReturnRecord extends EntityPathBase<ReturnRecord> {

    private static final long serialVersionUID = 571996229L;

    public static final QReturnRecord returnRecord = new QReturnRecord("returnRecord");

    public final NumberPath<Integer> bookId = createNumber("bookId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isOverdue = createNumber("isOverdue", Integer.class);

    public final DateTimePath<java.util.Date> returnDate = createDateTime("returnDate", java.util.Date.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QReturnRecord(String variable) {
        super(ReturnRecord.class, forVariable(variable));
    }

    public QReturnRecord(Path<? extends ReturnRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReturnRecord(PathMetadata metadata) {
        super(ReturnRecord.class, metadata);
    }

}

