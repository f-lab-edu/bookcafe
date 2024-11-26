package com.study.bookcafe.service;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.BorrowDAO;
import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.dto.BorrowDTO;
import com.study.bookcafe.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BookDAO bookDAO;
    private final BorrowDAO borrowDAO;

    public BorrowServiceImpl(BookDAO bookDAO, BorrowDAO borrowDAO) {
        this.bookDAO = bookDAO;
        this.borrowDAO = borrowDAO;
    }

    /**
     * 새로운 대출을 생성한다.
     *
     * @param member 회원
     * @param book   도서
     * @return 생성한 대출 정보
     */
    @Override
    public BorrowDTO createBorrow(MemberDTO member, BookDTO book) {
        BorrowDTO newBorrow = new BorrowDTO(member.getMemberId(), book.getBookId(), book.getISBN());
        return borrowDAO.save(newBorrow);
    }

    /**
     * 대출이 성공했는지 확인한다.
     *
     * @param borrow 대출
     * @return 대출이 성공했는지 여부
     */
    @Override
    public boolean successBorrow(BorrowDTO borrow) {
        return borrow != null;
    }


}
