package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class Return {
    private Member member;
    private BookInventory book;
    private LocalDateTime date;
}
