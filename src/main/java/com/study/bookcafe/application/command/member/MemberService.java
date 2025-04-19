package com.study.bookcafe.application.command.member;

import com.study.bookcafe.domain.member.Member;

public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);
    void save(Member member);
}
