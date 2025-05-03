package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
public class BorrowEntity {
    @Id
    private long id;                        // 대출 ID
    @NonNull
    @OneToOne
    private MemberEntity member;            // 회원
    @NonNull
    @OneToOne
    private BookInventoryEntity book;       // 도서
    @NonNull
    private LocalDateTime time;             // 대출 시간
    @Embedded
    private BorrowPeriod borrowPeriod;      // 대출 기간
    private int extensionCount;             // 대출 연장한 횟수
}
