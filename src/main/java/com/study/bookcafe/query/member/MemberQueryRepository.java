package com.study.bookcafe.query.member;


import java.util.Optional;

public interface MemberQueryRepository {
    Optional<MemberView> findById(long memberId);
}
