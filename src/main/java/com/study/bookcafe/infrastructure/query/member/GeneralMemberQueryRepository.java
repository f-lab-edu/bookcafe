package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.query.member.MemberQueryRepository;
import com.study.bookcafe.query.member.MemberView;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralMemberQueryRepository implements MemberQueryRepository {

    private final MemberMapper memberMapper;

    public GeneralMemberQueryRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    public MemberView findById(long memberId) {
        return TestMemberQueryStorage.memberViews.get(memberId);
    }
}
