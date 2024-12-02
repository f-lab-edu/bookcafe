package com.study.bookcafe.service;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.domain.Book;
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
}
