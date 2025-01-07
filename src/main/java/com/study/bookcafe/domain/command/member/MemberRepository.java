package com.study.bookcafe.domain.command.member;


public interface MemberRepository {
    Member findById(long memberId);
}
