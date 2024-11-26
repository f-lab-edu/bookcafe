package com.study.bookcafe.service;

import com.study.bookcafe.dao.BookDAO;
import com.study.bookcafe.dto.BookDTO;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * 도서를 ID로 조회한다.
     *
     * @param bookId 도서 ID
     * @return 도서
     */
    @Override
    public BookDTO findById(long bookId) {
        return bookDAO.findById(bookId);
    }

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @param book 도서
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    @Override
    public boolean canBorrow(BookDTO book) {
        return book.getInventory() != null && book.getInventory().isOnStock();
    }
}
