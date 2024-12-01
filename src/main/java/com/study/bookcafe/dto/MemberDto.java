package com.study.bookcafe.dto;

import com.study.bookcafe.domain.Level;
import com.study.bookcafe.domain.Member;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private long id;                  // 회원 ID
    private String memberName;              // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    // MemberDTO to Member
    public Member toDomain() {
        return Member.builder()
                .id(this.getId())
                .memberName(this.getMemberName())
                .level(this.getLevel())
                .borrowCount(this.getBorrowCount())
                .build();
    }

    // Member to MemberDTO
    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .memberName(member.getMemberName())
                .level(member.getLevel())
                .borrowCount(member.getBorrowCount())
                .build();
    }
}
