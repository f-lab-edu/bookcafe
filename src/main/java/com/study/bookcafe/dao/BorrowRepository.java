package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BorrowEntity;

import java.util.List;

public interface BorrowRepository {

    BorrowEntity findById(long borrowId);
    BorrowEntity save(BorrowEntity borrowEntity);
    List<BorrowEntity> save(List<BorrowEntity> borrowEntityList);

}
