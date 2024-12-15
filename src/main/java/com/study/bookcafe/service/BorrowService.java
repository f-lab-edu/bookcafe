package com.study.bookcafe.service;

import com.study.bookcafe.domain.Borrow;

import java.util.Collection;
import java.util.List;

public interface BorrowService {
    // 대출 저장
    Borrow save(Borrow borrow);

    // 여러 대출 저장
    List<Borrow> save(Collection<Borrow> borrows);
}