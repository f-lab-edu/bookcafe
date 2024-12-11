package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Borrow;
import java.util.List;

public interface BorrowRepository {

    Borrow findById(long borrowId);
    Borrow save(Borrow borrow);
    List<Borrow> save(List<Borrow> borrowList);

}
