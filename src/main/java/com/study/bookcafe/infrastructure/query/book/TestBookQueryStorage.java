package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.query.book.BookInventoryView;
import com.study.bookcafe.query.book.BookView;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBookQueryStorage {

    /************************* Command *************************/
    // id, BookInventory
    public static Map<Long, BookInventory> bookInventories =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_INVENTORY,
                    BookTestSets.WHITE_BOOK_INVENTORY
            ).collect(Collectors.toMap(
                    BookInventory::getId,
                    bookInventory -> bookInventory
            ));

    // bookId, BookInventory
    public static Map<Long, BookInventory> bookInventories2 =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_INVENTORY,
                    BookTestSets.WHITE_BOOK_INVENTORY
            ).collect(Collectors.toMap(
                    BookInventory::getBookId,
                    bookInventory -> bookInventory
            ));

    public static Map<Long, BookInventoryEntity> bookInventoryEntities =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_INVENTORY_ENTITY,
                    BookTestSets.WHITE_BOOK_INVENTORY_ENTITY
            ).collect(Collectors.toMap(
                    BookInventoryEntity::getId,
                    bookInventoryEntity -> bookInventoryEntity
            ));

    /************************* Query *************************/
    // id, BookInventoryView
    public static Map<Long, BookInventoryView> bookInventoryViews =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_INVENTORY_VIEW,
                    BookTestSets.WHITE_BOOK_INVENTORY_VIEW
            ).collect(Collectors.toMap(
                    BookInventoryView::getId,
                    bookInventoryView -> bookInventoryView
            ));

    // bookId, BookInventoryView
    public static Map<Long, BookInventoryView> bookInventoryViews2 =
            Stream.of(
                    BookTestSets.VEGETARIAN_BOOK_INVENTORY_VIEW,
                    BookTestSets.WHITE_BOOK_INVENTORY_VIEW
            ).collect(Collectors.toMap(
                    BookInventoryView::getBookId,
                    bookInventoryView -> bookInventoryView
            ));
}
