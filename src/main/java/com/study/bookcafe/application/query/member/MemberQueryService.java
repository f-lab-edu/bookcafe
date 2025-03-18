package com.study.bookcafe.application.query.member;

import com.study.bookcafe.query.member.MemberView;

public interface MemberQueryService {
    // 회원 조회 (id)
    MemberView findById(long memberId);
}
