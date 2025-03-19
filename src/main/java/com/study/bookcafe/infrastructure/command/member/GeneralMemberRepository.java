package com.study.bookcafe.infrastructure.command.member;

import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.member.MemberRepository;
import com.study.bookcafe.infrastructure.query.member.TestMemberQueryStorage;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GeneralMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Optional<Member> findById(long memberId) {
        return Optional.ofNullable(TestMemberQueryStorage.members.get(memberId));
    }
}
