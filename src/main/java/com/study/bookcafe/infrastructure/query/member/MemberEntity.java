package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.member.Level;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class MemberEntity {
    private long id;                        // 회원 ID
    private String password;                // 회원 Password
    private String name;                    // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
    private int reservationCount;           // 현재 예약 권수

    private LocalDateTime createDate;       // 회원 가입 일자
    private LocalDateTime updateDate;       // 회원 수정 일자
}
