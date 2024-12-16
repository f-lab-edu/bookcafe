package com.study.bookcafe.service;

import com.study.bookcafe.repository.BookRepository;
import com.study.bookcafe.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
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
        return bookRepository.findById(bookId);
    }

    /**
     * 도서를 ID 목록으로 조회한다.
     *
     * @param bookIds 도서 ID 목록
     * @return 도서 목록
     */
    @Override
    public List<Book> findByIds(Collection<Long> bookIds) {
        return bookRepository.findByIds(bookIds);
    }
}
