package com.study.bookcafe.member;

import com.google.gson.Gson;
import com.study.bookcafe.application.command.borrow.BorrowService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.query.member.MemberQueryService;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.interfaces.common.JsonHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BorrowTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberQueryService memberQueryService;
    @Autowired
    private BorrowService borrowService;

    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        long memberId = 1;
        memberService.borrowBook(memberId, List.of(1L));

        List<BorrowDetails> borrows = memberQueryService.findBorrows(memberId);

        borrows.forEach(borrow -> assertThat(borrow.getMember().getId()).isEqualTo(memberId));

    }

    @Test
    @DisplayName("회원의 대출 목록을 조회한다.")
    public void testFindBorrows() {

        long memberId = 1L;

        List<BorrowDetails> borrows = memberQueryService.findBorrows(memberId);

        assertThat(borrows.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("회원이 도서 대출을 연장한다.")
    public void extendBorrow() {

        long memberId = 1L;
        long bookId = 1L;

        Optional<Borrow> targetBorrow = borrowService.findBorrowByMemberIdAndBookId(memberId, bookId, true);
        Borrow borrow = targetBorrow.orElseThrow();
        LocalDate before = borrow.getPeriod().getTo();

        // extend borrow
        memberService.extendBook(memberId, bookId);

        BorrowDto extendedBorrow = TestBorrowQueryStorage.borrowDtos.get(borrow.getId());
        LocalDate after = extendedBorrow.getPeriod().getTo();

        assertThat(before.plusWeeks(1)).isEqualTo(after);
    }
}
