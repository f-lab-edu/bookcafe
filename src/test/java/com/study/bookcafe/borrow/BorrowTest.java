package com.study.bookcafe.borrow;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.BorrowDAO;
import com.study.bookcafe.dao.GeneralMemberDAO;
import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.dto.MemberDTO;
import com.study.bookcafe.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BorrowTest {

    BookDAO bookDAO = new BookDAO();
    BorrowDAO borrowDAO = new BorrowDAO();
    BorrowService borrowService = new BorrowServiceImpl(bookDAO, borrowDAO);
    BookService bookService = new BookServiceImpl(bookDAO);
    MemberService memberService = new MemberServiceImpl(new GeneralMemberDAO(), bookDAO, borrowService, bookService);

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        BorrowService borrowService = new BorrowServiceImpl(bookDAO, borrowDAO);

        MemberDTO member1 = memberService.findById(1L);
        BookDTO book1 = bookService.findById(1L);
        ApiResult result1 = memberService.borrowBook(member1.getMemberId(), book1.getBookId());
        System.out.println(result1);

        MemberDTO member2 = memberService.findById(3L);
        BookDTO book2 = bookService.findById(2L);
        ApiResult result2 = memberService.borrowBook(member2.getMemberId(), book2.getBookId());
        System.out.println(result2);

        assertThat(result1.isSuccess()).isTrue();
        assertThat(result2.isSuccess()).isFalse();

    }
}
