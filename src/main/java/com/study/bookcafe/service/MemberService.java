package com.study.bookcafe.service;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    // 회원 조회 (id)
    MemberDTO findById(long memberId);

    // 대출 상태 확인
    boolean canBorrow(MemberDTO member);

    // 도서 대출
    ApiResult borrowBook(long memberId, long bookId);
}
