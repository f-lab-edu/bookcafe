package com.study.bookcafe.interfaces.borrow;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestBorrowDto {
    private int memberId;
    private List<Long> bookdIdList;
}
