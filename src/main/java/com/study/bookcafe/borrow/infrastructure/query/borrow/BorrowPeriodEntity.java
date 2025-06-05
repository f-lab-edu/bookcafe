package com.study.bookcafe.borrow.infrastructure.query.borrow;

import com.study.bookcafe.domain.member.Level;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BorrowPeriodEntity {

    @Embedded
    DatePeriodEntity period;
    @Enumerated(EnumType.STRING)
    Level level;
}
