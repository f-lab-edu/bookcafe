package com.study.bookcafe.book;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.service.BookService;
import com.study.bookcafe.service.BookServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class canBorrowTest {

    TestBookRepository bookRepository = new TestBookRepository();
    BookService bookService = new BookServiceImpl(bookRepository);

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        Book book1 = bookService.findById(1L);
        Book book2 = bookService.findById(2L);

        assertThat(bookService.canBorrow(book1)).isEqualTo(true);
        assertThat(bookService.canBorrow(book2)).isEqualTo(false);

    }
}