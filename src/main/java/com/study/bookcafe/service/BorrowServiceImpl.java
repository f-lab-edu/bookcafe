package com.study.bookcafe.service;

import com.study.bookcafe.dao.BorrowRepository;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.entity.BorrowEntity;
import com.study.bookcafe.mapper.BorrowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;

    public BorrowServiceImpl(BorrowRepository borrowRepository, BorrowMapper borrowMapper) {
        this.borrowRepository = borrowRepository;
        this.borrowMapper = borrowMapper;
    }

    /**
     * 새로운 대출을 저장한다.
     *
     * @param borrow   대출 정보
     * @return 생성한 대출 정보
     */
    @Override
    public Borrow save(Borrow borrow) {
        BorrowEntity borrowEntity = borrowRepository.save(borrowMapper.toBorrowEntity(borrow));
        return borrowMapper.toBorrow(borrowEntity);
    }
    /**
     * 새로운 여러 대출들을 저장한다.
     *
     * @param borrowList 대출 목록
     * @return 생성한 대출 정보 목록
     */
    @Override
    public List<Borrow> save(List<Borrow> borrowList) {
        List<BorrowEntity> borrowEntityList = borrowMapper.toBorrowEntityList(borrowList);
        return borrowMapper.toBorrowList(borrowEntityList);
    }
}
