package com.study.bookcafe.infrastructure.command.member;

import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.domain.command.member.MemberRepository;
import com.study.bookcafe.infrastructure.query.member.TestMemberQueryStorage;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Member findById(long memberId) {
        return TestMemberQueryStorage.members.get(memberId);
    }
}
