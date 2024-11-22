package com.study.bookcafe.member;

import com.study.bookcafe.dto.Level;
import com.study.bookcafe.dto.MemberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BorrowTest {

    @Test
    @DisplayName("회원이 현재 대출가능한 상태인지 확인한다. (회원등급별로 최대 대출 권수가 상이함)")
    public void checkMemberStatusForBorrow() {

        /*
            회원의 현재 도서 대출 수
            회원의 등급(enum)
         */

        MemberDTO member1 = new MemberDTO("김도훈", Level.BASIC, 3);
        MemberDTO member2 = new MemberDTO("슈카", Level.BASIC, 2);
        MemberDTO member3 = new MemberDTO("트럼프", Level.WORM, 5);
        MemberDTO member4 = new MemberDTO("머스크", Level.WORM, 4);
        MemberDTO member5 = new MemberDTO("이상혁", Level.LIBRARIAN, 10);
        MemberDTO member6 = new MemberDTO("손흥민", Level.LIBRARIAN, 9);

        assertThat(member1.canBorrow()).isEqualTo(false);
        assertThat(member2.canBorrow()).isEqualTo(true);
        assertThat(member3.canBorrow()).isEqualTo(false);
        assertThat(member4.canBorrow()).isEqualTo(true);
        assertThat(member5.canBorrow()).isEqualTo(false);
        assertThat(member6.canBorrow()).isEqualTo(true);

    }
}
