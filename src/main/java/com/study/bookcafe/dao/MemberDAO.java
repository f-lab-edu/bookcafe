package com.study.bookcafe.dao;

import com.study.bookcafe.dto.MemberDTO;

public interface MemberDAO {
    MemberDTO findById(long memberId);
}
