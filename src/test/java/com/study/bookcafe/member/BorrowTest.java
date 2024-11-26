package com.study.bookcafe.member;

import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.BorrowDAO;
import com.study.bookcafe.dao.GeneralMemberDAO;
import com.study.bookcafe.entity.Level;
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
    @DisplayName("회원이 현재 대출가능한 상태인지 확인한다. (회원등급별로 최대 대출 권수가 상이함)")
    public void checkMemberStatusForBorrow() {

        /*
            회원의 현재 도서 대출 수
            회원의 등급(enum)
         */


        MemberDTO member1 = MemberDTO.builder().memberName("김도훈").level(Level.BASIC).borrowCount(2).build();
        MemberDTO member2 = MemberDTO.builder().memberName("슈카").level(Level.BASIC).borrowCount(2).build();
        MemberDTO member3 = MemberDTO.builder().memberName("트럼프").level(Level.WORM).borrowCount(5).build();
        MemberDTO member4 = MemberDTO.builder().memberName("머스크").level(Level.WORM).borrowCount(4).build();
        MemberDTO member5 = MemberDTO.builder().memberName("이상혁").level(Level.LIBRARIAN).borrowCount(10).build();
        MemberDTO member6 = MemberDTO.builder().memberName("손흥민").level(Level.LIBRARIAN).borrowCount(9).build();

        assertThat(memberService.canBorrow(member1)).isEqualTo(true);
        assertThat(memberService.canBorrow(member2)).isEqualTo(true);
        assertThat(memberService.canBorrow(member3)).isEqualTo(false);
        assertThat(memberService.canBorrow(member4)).isEqualTo(true);
        assertThat(memberService.canBorrow(member5)).isEqualTo(false);
        assertThat(memberService.canBorrow(member6)).isEqualTo(true);

    }
}
