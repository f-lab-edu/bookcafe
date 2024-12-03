package com.study.bookcafe.member;

import com.study.bookcafe.domain.Level;
import com.study.bookcafe.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanBorrowTest {

    @Test
    @DisplayName("회원이 현재 대출가능한 상태인지 확인한다. (회원등급별로 최대 대출 권수가 상이함)")
    public void checkMemberStatusForBorrow() {

        /*
            회원의 현재 도서 대출 수
            회원의 등급(enum)
         */

        Member member1 = Member.builder().name("김도훈").level(Level.BASIC).borrowCount(2).build();
        Member member2 = Member.builder().name("슈카").level(Level.BASIC).borrowCount(2).build();
        Member member3 = Member.builder().name("트럼프").level(Level.WORM).borrowCount(5).build();
        Member member4 = Member.builder().name("머스크").level(Level.WORM).borrowCount(4).build();
        Member member5 = Member.builder().name("이상혁").level(Level.LIBRARIAN).borrowCount(10).build();
        Member member6 = Member.builder().name("손흥민").level(Level.LIBRARIAN).borrowCount(9).build();

        assertThat(member1.canBorrow()).isEqualTo(true);
        assertThat(member2.canBorrow()).isEqualTo(true);
        assertThat(member3.canBorrow()).isEqualTo(false);
        assertThat(member4.canBorrow()).isEqualTo(true);
        assertThat(member5.canBorrow()).isEqualTo(false);
        assertThat(member6.canBorrow()).isEqualTo(true);

    }
}
