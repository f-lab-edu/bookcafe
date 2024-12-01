package com.study.bookcafe.domain;

import com.study.bookcafe.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Member {
    private long id;                        // 회원 ID
    private String memberName;              // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(this.getId())
                .memberName(this.getMemberName())
                .level(this.getLevel())
                .borrowCount(this.getBorrowCount())
                .build();
    }

    public static Member from(MemberEntity memberEntity) {
        return Member.builder()
                .id(memberEntity.getId())
                .memberName(memberEntity.getMemberName())
                .level(memberEntity.getLevel())
                .borrowCount(memberEntity.getBorrowCount())
                .build();
    }

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    public boolean canBorrow() {
        return this.getLevel().isBookBorrowCountLeft(getBorrowCount());
    }

    public Borrow borrowBook(Book book) {

        if(!this.canBorrow()) {

        }

        if(!book.canBorrow()) {

        }

        return new Borrow(this, book);
    }
}
