package com.study.bookcafe.repository;

import com.study.bookcafe.domain.Level;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.entity.MemberEntity;
import com.study.bookcafe.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GeneralMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    Map<Long, MemberEntity> members = new HashMap<>(){{
        put(1L, MemberEntity.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build());
        put(2L, MemberEntity.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build());
        put(3L, MemberEntity.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build());
    }};

    @Override
    public Member findById(long memberId) {
        MemberEntity memberEntity = members.get(memberId);
        return memberMapper.toMember(memberEntity);
    }
}
