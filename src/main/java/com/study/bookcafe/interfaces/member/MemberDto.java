package com.study.bookcafe.interfaces.member;

import com.study.bookcafe.domain.command.member.Level;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private long id;                        // 회원 ID
    private String name;                    // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
}
