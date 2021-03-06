package com.zsc.javaee_booktest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1630938509L;

    public static final QBook book = new QBook("book");

    public final StringPath author = createString("author");

    public final StringPath bookName = createString("bookName");

    public final StringPath classes = createString("classes");

    public final StringPath cover = createString("cover");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Float> price = createNumber("price", Float.class);

    public final StringPath pubDate = createString("pubDate");

    public final StringPath pubHouse = createString("pubHouse");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

