package com.study.bookcafe.borrow;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.service.*;
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

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        List<Borrow> borrows1 = memberService.borrowBook(1, List.of(1L));
        List<Borrow> borrows2 = memberService.borrowBook(3, List.of(2L));

//        assertThat(Borrow.successBorrow(borrow1)).isTrue();
        borrows1.forEach(borrow -> assertThat(Borrow.successBorrow(borrow)).isEqualTo(true));
        borrows2.forEach(borrow -> assertThat(Borrow.successBorrow(borrow)).isEqualTo(true));

    }
}
