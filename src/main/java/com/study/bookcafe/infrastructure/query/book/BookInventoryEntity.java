package com.study.bookcafe.infrastructure.query.book;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookInventoryEntity {
    private long id;                        // 인벤토리 ID
    private long bookId;                    // 도서 ID
    private BookEntity book;                // 도서
    private int stock;                      // 재고
    private int borrowedCount;              // 대출 건수
    private int reservedCount;              // 예약 건수
}
