package com.study.bookcafe.member;

import com.google.gson.Gson;
import com.study.bookcafe.application.member.MemberService;
import com.study.bookcafe.domain.borrow.BorrowDetails;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.domain.borrow.Borrow;
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

    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        List<Borrow> borrows1 = memberService.borrowBook(1, List.of(1L));
        List<Borrow> borrows2 = memberService.borrowBook(3, List.of(2L));

        System.out.println(gson.toJson(borrows1));

        borrows1.forEach(borrow -> assertThat(Borrow.successBorrow(borrow)).isEqualTo(true));
        borrows2.forEach(borrow -> assertThat(Borrow.successBorrow(borrow)).isEqualTo(true));

    }

    @Test
    @DisplayName("회원의 대출 목록을 조회한다.")
    public void testFindBorrows() {

        long memberId = 1L;

        List<BorrowDetails> borrows = memberService.findBorrows(memberId);

        assertThat(borrows.size()).isEqualTo(2);
    }
}
