package com.study.bookcafe.domain.member;


public interface MemberRepository {
    Member findById(long memberId);
}
