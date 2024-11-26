package com.study.bookcafe.book;

import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.service.BookService;
import com.study.bookcafe.service.BookServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BorrowTest {

    BookDAO bookDAO = new BookDAO();
    BookService bookService = new BookServiceImpl(bookDAO);

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        BookDTO book1 = BookDAO.books.get(1L);
        BookDTO book2 = BookDAO.books.get(2L);

        assertThat(bookService.canBorrow(book1)).isEqualTo(true);
        assertThat(bookService.canBorrow(book2)).isEqualTo(false);

    }
}