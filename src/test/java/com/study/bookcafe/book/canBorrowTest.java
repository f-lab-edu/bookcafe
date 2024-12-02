package com.study.bookcafe.book;

import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Inventory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class canBorrowTest {

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        Book book1 = Book.builder().id(1L).title("채식주의자").author("한강").inventory(new Inventory(5)).build();
        Book book2 = Book.builder().id(2L).title("흰").author("한강").inventory(new Inventory(0)).build();

        assertThat(book1.canBorrow()).isEqualTo(true);
        assertThat(book2.canBorrow()).isEqualTo(false);

    }
}