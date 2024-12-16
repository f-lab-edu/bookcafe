package com.study.bookcafe.repository;

import com.study.bookcafe.domain.Borrow;

import java.util.Collection;
import java.util.List;

public interface BorrowRepository {

    Borrow findById(long borrowId);
    Borrow save(Borrow borrow);
    List<Borrow> save(Collection<Borrow> borrows);

}
