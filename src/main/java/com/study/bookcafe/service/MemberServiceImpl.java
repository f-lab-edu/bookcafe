package com.study.bookcafe.service;

import com.study.bookcafe.common.ApiResult;
import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dao.MemberDAO;
import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.dto.BorrowDTO;
import com.study.bookcafe.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

    MemberDAO memberDAO;
    BookDAO bookDAO;
    BorrowService borrowService;
    BookService bookService;

    public MemberServiceImpl(MemberDAO memberDAO, BookDAO bookDAO, BorrowService borrowService, BookService bookService) {
        this.memberDAO = memberDAO;
        this.bookDAO = bookDAO;
        this.borrowService = borrowService;
        this.bookService = bookService;
    }

    /**
     * 회원을 ID로 조회한다.
     *
     * @param memberId 회원 ID
     * @return 회원
     */
    @Override
    public MemberDTO findById(long memberId) {
        return memberDAO.findById(memberId);
    }

    /**
     * 회원이 대출 가능한 상태인지 확인한다.
     *
     * @param member 회원
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    @Override
    public boolean canBorrow(MemberDTO member) {
        return member != null && member.getLevel() != null && member.getLevel().isBookBorrowCountLeft(member.getBorrowCount());
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
        MemberDTO member = findById(memberId);
        if(!canBorrow(member)) {
            return new ApiResult(false, "현재 회원님의 대출 가능 권수가 없습니다.");
        }

        BookDTO book = bookService.findById(bookId);
        if(!bookService.canBorrow(book)) {
            return new ApiResult(false, "현재 해당 도서는 모두 대출 중입니다.");
        }

        // 대출 객체를 생성해서 DB 저장 결과 및 데이터를를 리턴해주고 싶을 때 아래 방식말고 다른 방식도 궁금합니다.
        BorrowDTO borrow = borrowService.createBorrow(member, book);
        boolean borrowResult = borrowService.successBorrow(borrow);
        String message = borrowResult ? "해당 도서가 대출되었습니다." : "해당 도서가 대출되지 않았습니다.";

        return new ApiResult(borrowResult, borrow, message);
    }
}
