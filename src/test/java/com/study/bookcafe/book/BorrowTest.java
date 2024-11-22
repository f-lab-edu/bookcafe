package com.study.bookcafe.book;

import com.study.bookcafe.dto.BookDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BorrowTest {

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        BookDTO book1 = new BookDTO("채식주의자", 3, 1, 0);
        BookDTO book2 = new BookDTO("흰", 2, 2, 4);

        assertThat(book1.canBorrow()).isEqualTo(true);
        assertThat(book2.canBorrow()).isEqualTo(false);

    }
}