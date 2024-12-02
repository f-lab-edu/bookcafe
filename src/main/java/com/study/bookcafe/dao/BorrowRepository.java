package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BorrowEntity;

public interface BorrowRepository {

    BorrowEntity findById(long borrowId);
    BorrowEntity save(BorrowEntity borrowEntity);

}
