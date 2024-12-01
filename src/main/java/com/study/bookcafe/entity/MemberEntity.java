package com.study.bookcafe.entity;

import com.study.bookcafe.domain.Level;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberEntity {
    private long id;                        // 회원 ID
    private String memberName;              // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
}
