package com.study.bookcafe.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestBorrowDto {
    private int memberId;
    private List<Long> bookdIdList;
}
