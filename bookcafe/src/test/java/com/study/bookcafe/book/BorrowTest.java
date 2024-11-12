package com.study.bookcafe.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BorrowTest {

    @Test
    @DisplayName("도서가 현재 대출가능한 상태인지 확인한다. (도서의 현재 대출가능수량 확인")
    public void checkBookStatusForBorrow() {

        Book book1 = new Book("채식주의자", 3, 1, 0);
        Book book2 = new Book("흰", 2, 2, 4);

        assertThat(book1.canBorrowed()).isEqualTo(true);
        assertThat(book2.canBorrowed()).isEqualTo(false);

    }
}

class Book {
    String title;
    int inventory;
    int borrowed;
    int reservationCount;

    public Book(String title, int inventory, int borrowed, int reservationCount) {
        this.title = title;
        this.inventory = inventory;
        this.borrowed = borrowed;
        this.reservationCount = reservationCount;
    }

    public boolean canBorrowed() {
        return inventory - borrowed > 0;
    }
}