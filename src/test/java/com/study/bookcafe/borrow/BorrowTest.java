package com.study.bookcafe.borrow;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.dao.TestBorrowRepository;
import com.study.bookcafe.dao.GeneralMemberRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BorrowTest {

    TestBookRepository bookRepository = new TestBookRepository();
    TestBorrowRepository borrowRepository = new TestBorrowRepository();
    BorrowService borrowService = new BorrowServiceImpl(bookRepository, borrowRepository);
    BookService bookService = new BookServiceImpl(bookRepository);
    MemberService memberService = new MemberServiceImpl(new GeneralMemberRepository(), bookRepository, borrowService, bookService);

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        BorrowService borrowService = new BorrowServiceImpl(bookRepository, borrowRepository);

        Member member1 = memberService.findById(1L);
        Book book1 = bookService.findById(1L);
        Borrow borrow1 = memberService.borrowBook(member1, book1);

        Member member2 = memberService.findById(3L);
        Book book2 = bookService.findById(2L);
        Borrow borrow2 = memberService.borrowBook(member2, book2);

        assertThat(Borrow.successBorrow(borrow1)).isTrue();
        assertThat(Borrow.successBorrow(borrow2)).isTrue();

    }
}
