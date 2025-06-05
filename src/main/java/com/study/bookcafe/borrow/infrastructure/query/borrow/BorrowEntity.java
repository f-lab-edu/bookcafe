package com.study.bookcafe.borrow.infrastructure.query.borrow;

import com.study.bookcafe.borrow.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.borrow.infrastructure.query.borrower.BorrowerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity(name = "borrowContextBorrow")
@Table(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
public class BorrowEntity {
    @Id
    private long id;                            // 대출 ID
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private BorrowerEntity borrower;            // 회원
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private BookInventoryEntity book;           // 도서
    @NonNull
    private LocalDateTime time;                 // 대출 시간
    private LocalDateTime returnTime;           // 반납 시간
    @Embedded
    private BorrowPeriodEntity borrowPeriod;    // 대출 기간
    private int extensionCount;                 // 대출 연장한 횟수

}
