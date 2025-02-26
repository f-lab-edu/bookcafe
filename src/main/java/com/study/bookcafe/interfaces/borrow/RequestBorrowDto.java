package com.study.bookcafe.interfaces.borrow;

import lombok.Getter;

@Getter
public class RequestBorrowDto {
    private long memberId;
    private long bookdId;
}
