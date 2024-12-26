package com.study.bookcafe.domain.borrow;

import java.util.Collection;
import java.util.List;

public interface BorrowRepository {

    Borrow findById(long borrowId);
    Borrow save(Borrow borrow);
    List<Borrow> save(Collection<Borrow> borrows);
    Reservation save(Reservation reservation);

}
