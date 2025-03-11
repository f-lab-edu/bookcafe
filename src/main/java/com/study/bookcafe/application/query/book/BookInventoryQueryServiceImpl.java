package com.study.bookcafe.application.query.book;

import com.study.bookcafe.query.book.BookInventoryView;
import com.study.bookcafe.query.book.BookInventoryQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class BookInventoryQueryServiceImpl implements BookInventoryQueryService {

    private final BookInventoryQueryRepository bookInventoryQueryRepository;

    public BookInventoryQueryServiceImpl(BookInventoryQueryRepository bookInventoryQueryRepository) {
        this.bookInventoryQueryRepository = bookInventoryQueryRepository;
    }

    @Override
    public BookInventoryView findById(long id) {
        return bookInventoryQueryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }

    @Override
    public BookInventoryView findByBookId(long bookId) {
        return bookInventoryQueryRepository.findByBookId(bookId).orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }
}
