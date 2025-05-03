package com.study.bookcafe.infrastructure.query.book;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class BookInventoryEntity {
    @Id
    private long id;                        // 인벤토리 ID
    private long bookId;                    // 도서 ID
    @Embedded
    private BookEntity book;                // 도서
    private int stock;                      // 재고
    private int borrowedCount;              // 대출 건수
    private int reservedCount;              // 예약 건수
}
