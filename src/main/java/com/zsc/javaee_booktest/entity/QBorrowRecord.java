package com.zsc.javaee_booktest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBorrowRecord is a Querydsl query type for BorrowRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBorrowRecord extends EntityPathBase<BorrowRecord> {

    private static final long serialVersionUID = 1996553546L;

    public static final QBorrowRecord borrowRecord = new QBorrowRecord("borrowRecord");

    public final NumberPath<Integer> bookId = createNumber("bookId", Integer.class);

    public final DateTimePath<java.util.Date> borrow_date = createDateTime("borrow_date", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> returnDate = createDateTime("returnDate", java.util.Date.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QBorrowRecord(String variable) {
        super(BorrowRecord.class, forVariable(variable));
    }

    public QBorrowRecord(Path<? extends BorrowRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBorrowRecord(PathMetadata metadata) {
        super(BorrowRecord.class, metadata);
    }

}

