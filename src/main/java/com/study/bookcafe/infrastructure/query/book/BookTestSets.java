package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.interfaces.book.BookDto;
import com.study.bookcafe.interfaces.book.BookInventoryDto;
import com.study.bookcafe.query.book.BookInventoryView;
import com.study.bookcafe.query.book.BookView;

import java.sql.Date;
import java.time.LocalDate;

public class BookTestSets {

    public static final Book VEGETARIAN_BOOK = Book.builder().ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
            .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30))).price(35000).build();
    public static final Book WHITE_BOOK = Book.builder().ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2018, 4, 25))).price(13000).build();
    public static final Book HANRIVER_BOOK = Book.builder().ISBN(9788954686891L).title("한강").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2022, 5, 30))).price(15000).build();

    public static final BookEntity VEGETARIAN_BOOK_ENTITY = BookEntity.builder().ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
            .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30))).price(35000).build();
    public static final BookEntity WHITE_BOOK_ENTITY = BookEntity.builder().ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2018, 4, 25))).price(13000).build();
    public static final BookEntity HANRIVER_BOOK_ENTITY = BookEntity.builder().ISBN(9788954686891L).title("한강").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2022, 5, 30))).price(15000).build();

    public static final BookView VEGETARIAN_BOOK_VIEW = BookView.builder().ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
            .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30))).price(35000).build();
    public static final BookView WHITE_BOOK_VIEW = BookView.builder().ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2018, 4, 25))).price(13000).build();
    public static final BookView HANRIVER_BOOK_VIEW = BookView.builder().ISBN(9788954686891L).title("한강").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2022, 5, 30))).price(15000).build();

    public static final BookDto VEGETARIAN_BOOK_DTO = BookDto.builder().ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
            .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30))).price(35000).build();
    public static final BookDto WHITE_BOOK_DTO = BookDto.builder().ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2018, 4, 25))).price(13000).build();
    public static final BookDto HANRIVER_BOOK_DTO = BookDto.builder().ISBN(9788954686891L).title("한강").author("한강").publisher("문학동네")
            .publishDate(Date.valueOf(LocalDate.of(2022, 5, 30))).price(15000).build();



    public static final BookInventory VEGETARIAN_BOOK_INVENTORY = BookInventory.builder()
            .id(1L).bookId(1L).book(VEGETARIAN_BOOK).stock(5).borrowedCount(1).reservedCount(0).build();
    public static final BookInventory WHITE_BOOK_INVENTORY = BookInventory.builder()
            .id(2L).bookId(2L).book(WHITE_BOOK).stock(2).borrowedCount(2).reservedCount(1).build();
    public static final BookInventory HANRIVER_BOOK_INVENTORY = BookInventory.builder()
            .id(3L).bookId(3L).book(HANRIVER_BOOK).stock(5).borrowedCount(5).reservedCount(0).build();


    public static final BookInventoryEntity VEGETARIAN_BOOK_INVENTORY_ENTITY = BookInventoryEntity.builder()
            .id(1L).bookId(1L).book(VEGETARIAN_BOOK_ENTITY).stock(5).borrowedCount(1).reservedCount(0).build();
    public static final BookInventoryEntity WHITE_BOOK_INVENTORY_ENTITY = BookInventoryEntity.builder()
            .id(2L).bookId(2L).book(WHITE_BOOK_ENTITY).stock(2).borrowedCount(2).reservedCount(1).build();
    public static final BookInventoryEntity HANRIVER_BOOK_INVENTORY_ENTITY = BookInventoryEntity.builder()
            .id(3L).bookId(3L).book(HANRIVER_BOOK_ENTITY).stock(5).borrowedCount(5).reservedCount(0).build();

    public static final BookInventoryView VEGETARIAN_BOOK_INVENTORY_VIEW = BookInventoryView.builder()
            .id(1L).bookId(1L).bookView(VEGETARIAN_BOOK_VIEW).stock(5).borrowedCount(1).reservedCount(0).build();
    public static final BookInventoryView WHITE_BOOK_INVENTORY_VIEW = BookInventoryView.builder()
            .id(2L).bookId(2L).bookView(WHITE_BOOK_VIEW).stock(2).borrowedCount(2).reservedCount(1).build();
    public static final BookInventoryView HANRIVER_BOOK_INVENTORY_VIEW = BookInventoryView.builder()
            .id(3L).bookId(3L).bookView(HANRIVER_BOOK_VIEW).stock(5).borrowedCount(5).reservedCount(0).build();

    public static final BookInventoryDto VEGETARIAN_BOOK_INVENTORY_DTO = BookInventoryDto.builder()
            .id(1L).bookId(1L).book(VEGETARIAN_BOOK_DTO).stock(5).borrowedCount(1).reservedCount(0).build();
    public static final BookInventoryDto WHITE_BOOK_INVENTORY_DTO = BookInventoryDto.builder()
            .id(2L).bookId(2L).book(WHITE_BOOK_DTO).stock(2).borrowedCount(2).reservedCount(1).build();
    public static final BookInventoryDto HANRIVER_BOOK_INVENTORY_DTO = BookInventoryDto.builder()
            .id(3L).bookId(3L).book(HANRIVER_BOOK_DTO).stock(5).borrowedCount(5).reservedCount(0).build();

    public static BookInventory createVegetarianBookInventory() {
        return BookInventory.builder()
                .id(1L).bookId(1L).book(VEGETARIAN_BOOK).stock(5).borrowedCount(1).reservedCount(0).build();
    }
    public static BookInventory createWhiteBookInventory() {
        return BookInventory.builder()
                .id(2L).bookId(2L).book(WHITE_BOOK).stock(2).borrowedCount(2).reservedCount(1).build();
    }
    public static BookInventory createHanRiverBookInventory() {
        return BookInventory.builder()
                .id(3L).bookId(3L).book(HANRIVER_BOOK).stock(5).borrowedCount(5).reservedCount(0).build();
    }
}
