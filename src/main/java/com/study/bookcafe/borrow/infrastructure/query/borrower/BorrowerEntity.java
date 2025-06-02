package com.study.bookcafe.borrow.infrastructure.query.borrower;

import com.study.bookcafe.domain.member.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Builder
@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerEntity {
    @Id
    private long id;                        // 회원 ID
    @Enumerated(EnumType.STRING)
    private Level level;                    // 회원 등급
    @Formula("(SELECT count(1) FROM borrow b WHERE b.member_id = id)")
    private int borrowCount;                // 현재 대출 권수
}
