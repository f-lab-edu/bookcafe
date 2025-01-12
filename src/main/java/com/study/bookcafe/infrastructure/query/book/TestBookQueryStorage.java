package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.query.book.BookView;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBookQueryStorage {

    /************************* Command *************************/
    public static Map<Long, BookEntity> bookEntities =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_ENTITY,
                    BookTestSets.WHITE_BOOK_ENTITY
            ).collect(Collectors.toMap(
                    BookEntity::getId,
                    bookEntity -> bookEntity
            ));

    /************************* Query *************************/
    public static Map<Long, BookView> bookViews =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_VIEW,
                    BookTestSets.WHITE_BOOK_VIEW
            ).collect(Collectors.toMap(
                    BookView::getId,
                    bookView -> bookView
            ));
}
