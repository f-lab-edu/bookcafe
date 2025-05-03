package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.member.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    private long id;                        // 회원 ID
    private String password;                // 회원 Password
    private String name;                    // 회원 이름
    @Enumerated(EnumType.STRING)
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
    private int reservationCount;           // 현재 예약 권수

    private LocalDateTime createDate;       // 회원 가입 일자
    private LocalDateTime updateDate;       // 회원 수정 일자
}
