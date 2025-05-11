package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
public class BorrowEntity {
    @Id
    private long id;                            // 대출 ID
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;                // 회원
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private BookInventoryEntity book;           // 도서
    @NonNull
    private LocalDateTime time;                 // 대출 시간
    @Embedded
    private BorrowPeriodEntity borrowPeriod;    // 대출 기간
    private int extensionCount;                 // 대출 연장한 횟수

}
