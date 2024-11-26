package com.study.bookcafe.dto;

import com.study.bookcafe.entity.Level;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberDTO {
    private long memberId;                  // 회원 ID
    private String memberName;              // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
//    public boolean canBorrow() {
//        return level.isBookBorrowCountLeft(getBorrowCount());
//    }
}
