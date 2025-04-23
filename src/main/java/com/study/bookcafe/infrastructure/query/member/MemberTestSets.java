package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.infrastructure.query.borrow.PriorityBorrowRightTestSets;
import com.study.bookcafe.interfaces.member.MemberDto;
import com.study.bookcafe.query.member.MemberView;

public class MemberTestSets {

    public static final Member BASIC_MEMBER = Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).reservationCount(1).build();
    public static final Member WORM_MEMBER = Member.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).reservationCount(2).build();
    public static final Member LIBRARIAN_MEMBER = Member.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static final MemberEntity BASIC_MEMBER_ENTITY = MemberEntity.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).reservationCount(1).build();
    public static final MemberEntity WORM_MEMBER_ENTITY = MemberEntity.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).reservationCount(2).build();
    public static final MemberEntity LIBRARIAN_MEMBER_ENTITY = MemberEntity.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static final MemberView BASIC_MEMBER_VIEW = MemberView.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build();
    public static final MemberView WORM_MEMBER_VIEW = MemberView.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build();
    public static final MemberView LIBRARIAN_MEMBER_VIEW = MemberView.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static final MemberDto BASIC_MEMBER_DTO = MemberDto.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build();
    public static final MemberDto WORM_MEMBER_DTO = MemberDto.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build();
    public static final MemberDto LIBRARIAN_MEMBER_DTO = MemberDto.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static Member createBasicMember() {
        return Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).reservationCount(1).build();
    }
    public static Member createWormMember() {
        return Member.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).reservationCount(2).priorityBorrowRightsMap(PriorityBorrowRightTestSets.createWormPriorityBorrowRightMap).build();
    }
    public static Member createLibrarianMember() {
        return Member.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();
    }
}
