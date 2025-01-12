package com.study.bookcafe.member;

import com.google.gson.Gson;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.query.member.MemberQueryService;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.interfaces.common.JsonHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BorrowTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberQueryService memberQueryService;

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
}
