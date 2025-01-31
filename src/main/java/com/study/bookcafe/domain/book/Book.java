package com.study.bookcafe.domain.book;

import lombok.Builder;
import lombok.Getter;
import java.sql.Date;
import java.util.Optional;

@Builder
@Getter
public class Book {
    private long id;                        // 도서 번호
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
    private Inventory inventory;            // 도서 상태 정보 (재고, 대출, 예약)

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    public boolean canBorrow() {
        return findInventory()
                .map(Inventory::isOnStock)
                .orElse(false);
    }

    /**
     * 도서에 예약이 있는지 확인한다.
     *
     * @return 현재 도서에 대한 예약이 있는지 여부
     */
    public boolean haveReservation() {
        return findInventory()
                .map(Inventory::haveReservation)
                .orElse(false);
    }

    public Optional<Inventory> findInventory() {
        return Optional.ofNullable(this.getInventory());
    }
}
