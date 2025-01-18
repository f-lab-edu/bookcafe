package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.Inventory;
import com.study.bookcafe.interfaces.book.BookDto;
import com.study.bookcafe.query.book.BookView;

import java.sql.Date;
import java.time.LocalDate;

public class BookTestSets {

    public static final Book VEGETARIAN_BOOK = Book.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
            .price(35000).inventory(new Inventory(5)).build();
    public static final Book WHITE_BOOK = Book.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
            .price(13000).inventory(new Inventory(0)).build();

    public static final BookEntity VEGETARIAN_BOOK_ENTITY = BookEntity.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
            .price(35000).inventory(new Inventory(5)).build();
    public static final BookEntity WHITE_BOOK_ENTITY = BookEntity.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
            .price(13000).inventory(new Inventory(0)).build();

    public static final BookView VEGETARIAN_BOOK_VIEW = BookView.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
            .price(35000).inventory(new Inventory(5)).build();
    public static final BookView WHITE_BOOK_VIEW = BookView.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
            .price(13000).inventory(new Inventory(0)).build();

    public static final BookDto VEGETARIAN_BOOK_DTO = BookDto.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
            .price(35000).inventory(new Inventory(5)).build();
    public static final BookDto WHITE_BOOK_DTO = BookDto.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
            .price(13000).inventory(new Inventory(0)).build();
}
