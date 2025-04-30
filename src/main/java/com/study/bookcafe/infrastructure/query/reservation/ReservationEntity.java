package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.domain.borrow.PriorityBorrowPeriod;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private long id;                                        // 예약 번호
    @OneToOne
    private MemberEntity member;                            // 회원
    @OneToOne
    private BookInventoryEntity book;                       // 도서
    private LocalDateTime time;                             // 예약 시간
    @Embedded
    private PriorityBorrowPeriod priorityBorrowPeriod;      // 우선대출기간
}
