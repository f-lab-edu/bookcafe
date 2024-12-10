package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Member;

public interface MemberRepository {
    Member findById(long memberId);
}
