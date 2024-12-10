package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Level;
import com.study.bookcafe.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GeneralMemberRepository implements MemberRepository {

    Map<Long, Member> members = new HashMap<>(){{
        put(1L, Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build());
        put(2L, Member.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build());
        put(3L, Member.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build());
    }};

    @Override
    public Member findById(long memberId) {
        return members.get(memberId);
    }
}
