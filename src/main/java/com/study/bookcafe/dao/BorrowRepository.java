package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BorrowEntity;

public interface BorrowRepository {

    BorrowEntity find(BorrowEntity borrowEntity);
    BorrowEntity save(BorrowEntity borrowEntity);

}
