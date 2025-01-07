package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.command.member.Level;
import com.study.bookcafe.domain.query.member.MemberQueryRepository;
import com.study.bookcafe.domain.query.member.MemberView;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GeneralMemberQueryRepository implements MemberQueryRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberQueryRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    Map<Long, MemberView> memberViews = new HashMap<>(){{
        put(1L, MemberView.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).build());
        put(2L, MemberView.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).build());
        put(3L, MemberView.builder().id(3L).name("트럼프").level(Level.LIBRARIAN).borrowCount(5).build());
    }};

    @Override
    public MemberView findById(long memberId) {
        return memberViews.get(memberId);
    }
}
