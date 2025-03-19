package com.study.bookcafe.domain.member;


import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(long memberId);
}
