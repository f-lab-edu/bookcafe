package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.query.member.MemberQueryRepository;
import com.study.bookcafe.query.member.MemberView;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GeneralMemberQueryRepository implements MemberQueryRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberQueryRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    public Optional<MemberView> findById(long memberId) {
        return Optional.ofNullable(TestMemberQueryStorage.memberViews.get(memberId));
    }
}
