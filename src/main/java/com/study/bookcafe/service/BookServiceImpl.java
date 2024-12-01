package com.study.bookcafe.service;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.dto.BookDto;
import com.study.bookcafe.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    TestBookRepository bookRepository;

    public BookServiceImpl(TestBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 도서를 ID로 조회한다.
     *
     * @param bookId 도서 ID
     * @return 도서
     */
    @Override
    public Book findById(long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId);
        return Book.from(bookEntity);
    }

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @param book 도서
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    @Override
    public boolean canBorrow(Book book) {
        return book.getInventory() != null && book.getInventory().isOnStock();
    }
}
