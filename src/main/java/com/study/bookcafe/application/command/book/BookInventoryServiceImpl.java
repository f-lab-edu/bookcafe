package com.study.bookcafe.application.command.book;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.book.BookInventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {

    private final BookInventoryRepository bookInventoryRepository;

    public BookInventoryServiceImpl(BookInventoryRepository bookInventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
    }

    @Override
    public BookInventory findById(long id) {
        return bookInventoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }

    @Override
    public BookInventory findByBookId(long bookId) {
        return bookInventoryRepository.findByBookId(bookId).orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }

    @Override
    public void update(BookInventory bookInventory) {
        bookInventoryRepository.update(bookInventory);
    }
}
