package com.study.bookcafe.member;

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

        Member member1 = new Member(Level.BASIC, 3);
        Member member2 = new Member(Level.BASIC, 2);
        Member member3 = new Member(Level.WORM, 5);
        Member member4 = new Member(Level.WORM, 4);
        Member member5 = new Member(Level.LIBRARIAN, 10);
        Member member6 = new Member(Level.LIBRARIAN, 9);

        assertThat(member1.canBorrow()).isEqualTo(false);
        assertThat(member2.canBorrow()).isEqualTo(true);
        assertThat(member3.canBorrow()).isEqualTo(false);
        assertThat(member4.canBorrow()).isEqualTo(true);
        assertThat(member5.canBorrow()).isEqualTo(false);
        assertThat(member6.canBorrow()).isEqualTo(true);

    }
}

class Member {
    Level level;
    int borrowCount;

    public Member(Level level, int borrowCount) {
        this.level = level;
        this.borrowCount = borrowCount;
    }

    public boolean canBorrow() {
        return level.getMaximumBorrowCount() - borrowCount > 0;
    }
}

enum Level {
    LIBRARIAN(3, 10,null), WORM(2, 5,null), BASIC(1, 3, WORM);

    private int value;
    private int maximumBorrowCount;
    private Level next;

    Level(int value, int maximumBorrowCount, Level next) {
        this.value = value;
        this.maximumBorrowCount = maximumBorrowCount;
        this.next = next;
    }

    public int getMaximumBorrowCount() {
        return maximumBorrowCount;
    }
}
