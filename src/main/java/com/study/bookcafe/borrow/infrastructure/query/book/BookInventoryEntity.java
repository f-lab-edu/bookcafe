package com.study.bookcafe.borrow.infrastructure.query.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Builder
@Getter
@Entity(name = "borrowContextBookInventory")
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class BookInventoryEntity {
    @Id
    private long id;                        // 인벤토리 ID
    private long bookId;                    // 도서 ID
    private int stock;                      // 재고
    @Formula("(SELECT count(1) FROM borrow b WHERE b.book_id = book_id)")
    private int borrowedCount;              // 대출 건수
    private int reservedCount;              // 예약 건수
    @Formula("(SELECT count(1) FROM reservation r WHERE r.book_id = book_id AND r.from IS NOT NULL AND r.to IS NOT NULL)")
    private int priorityBorrowCount;        // 우선대출예약 건수
}
