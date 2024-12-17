package com.study.bookcafe.repository;

import com.study.bookcafe.domain.Member;

public interface MemberRepository {
    Member findById(long memberId);
}
