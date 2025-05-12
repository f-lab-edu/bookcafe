package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.borrow.PriorityBorrowPeriodEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
    @Id
    private long id;                                            // 예약 번호
    @ManyToOne // (fetch = FetchType.LAZY)
    private MemberEntity member;                                // 회원
    @ManyToOne // (fetch = FetchType.LAZY)
    private BookInventoryEntity book;                           // 도서
    private LocalDateTime time;                                 // 예약 시간
    @Embedded
    private PriorityBorrowPeriodEntity priorityBorrowPeriod;    // 우선대출기간
}
