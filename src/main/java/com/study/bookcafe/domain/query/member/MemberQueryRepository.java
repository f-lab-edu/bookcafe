package com.study.bookcafe.domain.query.member;


public interface MemberQueryRepository {
    MemberView findById(long memberId);
}
