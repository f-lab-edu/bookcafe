package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.member.Level;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

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
