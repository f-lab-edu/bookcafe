package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.command.member.Level;
import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.domain.query.member.MemberView;

public class MemberTestSets {

    public static final Member BASIC_MEMBER = Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build();
    public static final Member WORM_MEMBER = Member.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build();
    public static final Member LIBRARIAN_MEMBER = Member.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static final MemberEntity BASIC_MEMBER_ENTITY = MemberEntity.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build();
    public static final MemberEntity WORM_MEMBER_ENTITY = MemberEntity.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build();
    public static final MemberEntity LIBRARIAN_MEMBER_ENTITY = MemberEntity.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

    public static final MemberView BASIC_MEMBER_VIEW = MemberView.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build();
    public static final MemberView WORM_MEMBER_VIEW = MemberView.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build();
    public static final MemberView LIBRARIAN_MEMBER_VIEW = MemberView.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build();

}
