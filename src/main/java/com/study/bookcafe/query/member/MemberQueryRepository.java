package com.study.bookcafe.query.member;


public interface MemberQueryRepository {
    MemberView findById(long memberId);
}
