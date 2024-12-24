package com.study.bookcafe.infrastructure.member;

import com.study.bookcafe.domain.member.Level;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberEntity {
    private long id;                        // 회원 ID
    private String name;                    // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
}
