package com.study.bookcafe.service;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.BorrowDAO;
import com.study.bookcafe.dao.MemberDAO;
import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.dto.BorrowDTO;
import com.study.bookcafe.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class BorrowServiceImpl implements BorrowService {

    private final MemberDAO memberDAO;
    private final BookDAO bookDAO;
    private final BorrowDAO borrowDAO;

    public BorrowServiceImpl(MemberDAO memberDAO, BookDAO bookDAO, BorrowDAO borrowDAO) {
        this.memberDAO = memberDAO;
        this.bookDAO = bookDAO;
        this.borrowDAO = borrowDAO;
    }

    /**
     * 회원이 도서를 대출한다.
     *
     * @param memberId  회원 ID
     * @param bookId    도서 ID
     * @return 도서 대출 결과(성공여부, 데이터, 결과메세지)
     */
    @Override
    public ApiResult borrowBook(long memberId, long bookId) {

        /*
            1. 회원이 대출 가능한 상태인지 확인
            2. 회원이 대출하려는 도서가 대출 가능한 상태인지 확인
            3. 회원이 도서를 대출
            4. 회원-도서(도서번호, ISBN) 매핑된 대출 데이터 추가

            동시성 이슈
            트랜잭션 처리 필요
         */

        MemberDTO member = memberDAO.findById(memberId);
        if(!member.canBorrow()) {
            return new ApiResult(false, "현재 회원님의 대출 가능 권수가 없습니다.");
        }

        BookDTO book = bookDAO.findById(bookId);
        if(!book.canBorrow()) {
            return new ApiResult(false, "현재 해당 도서는 모두 대출 중입니다.");
        }

        BorrowDTO borrowDTO = borrowDAO.find(memberId, bookId, book.getISBN());
        if(borrowDTO != null) {
            return new ApiResult(false, "이미 해당 도서를 대출 중입니다.");
        }

        BorrowDTO newBorrowDTO = new BorrowDTO(memberId, bookId, book.getISBN());
        borrowDAO.save(newBorrowDTO);

        return new ApiResult(true, newBorrowDTO,"해당 도서에 대한 대출이 완료되었습니다.");
    }



}
