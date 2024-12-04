package com.study.bookcafe.dao;

import com.study.bookcafe.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity findById(long memberId);
}
