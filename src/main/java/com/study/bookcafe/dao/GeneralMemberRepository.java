package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Level;
import com.study.bookcafe.dto.MemberDto;
import com.study.bookcafe.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GeneralMemberRepository implements MemberRepository {

    Map<Long, MemberEntity> members = new HashMap<>(){{
        put(1L, MemberEntity.builder().id(1L).memberName("슈카").level(Level.BASIC).borrowCount(0).build());
        put(2L, MemberEntity.builder().id(2L).memberName("머스크").level(Level.WORM).borrowCount(3).build());
        put(3L, MemberEntity.builder().id(3L).memberName("트럼프").level(Level.LIBRARIAN).borrowCount(5).build());
    }};

    @Override
    public MemberEntity findById(long memberId) {
        return members.get(memberId);
    }
}
