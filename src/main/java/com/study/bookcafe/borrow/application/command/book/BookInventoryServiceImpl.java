package com.study.bookcafe.borrow.application.command.book;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.book.BookInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("borrowContextBookInventoryService")
public class BookInventoryServiceImpl implements BookInventoryService {

    private final BookInventoryRepository bookInventoryRepository;

    public BookInventoryServiceImpl(BookInventoryRepository bookInventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
    }

    @Override
    public Optional<BookInventory> findByBookId(long bookId) {
        return bookInventoryRepository.findByBookId(bookId);
    }
}
