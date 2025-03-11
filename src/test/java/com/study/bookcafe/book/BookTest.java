package com.study.bookcafe.book;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BookTest {

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        BookInventory book1 = BookTestSets.VEGETARIAN_BOOK_INVENTORY;
        BookInventory book2 = BookTestSets.WHITE_BOOK_INVENTORY;

        assertThat(book1.isBorrowable()).isEqualTo(true);
        assertThat(book2.isBorrowable()).isEqualTo(false);

    }

    @Test
    @DisplayName("도서에 대한 예약이 있는지 확인한다.")
    public void checkHaveReservationForBook() {

        BookInventory book1 = BookTestSets.VEGETARIAN_BOOK_INVENTORY;
        BookInventory book2 = BookTestSets.WHITE_BOOK_INVENTORY;

        assertThat(book1.haveReservation()).isEqualTo(false);
        assertThat(book2.haveReservation()).isEqualTo(true);
    }
}