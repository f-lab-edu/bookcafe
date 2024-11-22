package com.study.bookcafe.borrow;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.BorrowDAO;
import com.study.bookcafe.dao.GeneralMemberDAO;
import com.study.bookcafe.dao.MemberDAO;
import com.study.bookcafe.service.BorrowService;
import com.study.bookcafe.service.BorrowServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BorrowTest {

    BookDAO bookDAO = new BookDAO();
    BorrowDAO borrowDAO = new BorrowDAO();
    MemberDAO memberDAO = new GeneralMemberDAO();

    @Test
    @DisplayName("회원이 도서를 대출한다.")
    public void testBorrowBook() {

        BorrowService borrowService = new BorrowServiceImpl(memberDAO, bookDAO, borrowDAO);

        ApiResult result1 = borrowService.borrowBook(1L, 1L);
        System.out.println(result1);
        ApiResult result2 = borrowService.borrowBook(3L, 1L);
        System.out.println(result2);

        assertThat(result1.isSuccess()).isFalse();
        assertThat(result2.isSuccess()).isTrue();

    }
}
