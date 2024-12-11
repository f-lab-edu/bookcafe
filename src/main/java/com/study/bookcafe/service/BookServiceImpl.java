package com.study.bookcafe.service;

import com.study.bookcafe.dao.BookRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
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
     * @param bookIdList 도서 ID 목록
     * @return 도서 목록
     */
    @Override
    public List<Book> findByIdList(List<Long> bookIdList) {
        return bookRepository.findByIdList(bookIdList);
    }
}
