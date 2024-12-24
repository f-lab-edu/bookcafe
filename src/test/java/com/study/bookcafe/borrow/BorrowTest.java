package com.study.bookcafe.borrow;

import com.google.gson.Gson;
import com.study.bookcafe.application.member.MemberService;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
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
    private BorrowMapper borrowMapper;

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
}
