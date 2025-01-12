package com.study.bookcafe.infrastructure.command.book;

import com.study.bookcafe.domain.command.book.Book;
import com.study.bookcafe.domain.command.book.BookRepository;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.book.TestBookQueryStorage;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class TestBookRepository implements BookRepository {

    private final BookMapper bookMapper;

    public TestBookRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Book findById(long bookId) {
        BookEntity bookEntity = TestBookQueryStorage.bookEntities.get(bookId);
        return bookMapper.toBook(bookEntity);
    }

    @Override
    public List<Book> findByIds(Collection<Long> bookIds) {
        List<BookEntity> bookEntities = bookIds.stream()
                .filter(id -> TestBookQueryStorage.bookEntities.containsKey(id))
                .map(id -> TestBookQueryStorage.bookEntities.get(id)).toList();
        return bookMapper.toBookList(bookEntities);
    }

}
