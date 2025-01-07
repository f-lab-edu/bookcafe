package com.study.bookcafe.application.query.book;

import com.study.bookcafe.domain.query.book.BookQueryRepository;
import com.study.bookcafe.domain.query.book.BookView;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class BookQueryServiceImpl implements BookQueryService {

    private final BookQueryRepository bookQueryRepository;

    public BookQueryServiceImpl(BookQueryRepository bookQueryRepository) {
        this.bookQueryRepository = bookQueryRepository;
    }

    /**
     * 도서를 ID로 조회한다.
     *
     * @param bookId 도서 ID
     * @return 도서
     */
    @Override
    public BookView findById(long bookId) {
        return bookQueryRepository.findById(bookId);
    }

    /**
     * 도서를 ID 목록으로 조회한다.
     *
     * @param bookIds 도서 ID 목록
     * @return 도서 목록
     */
    @Override
    public List<BookView> findByIds(Collection<Long> bookIds) {
        return bookQueryRepository.findByIds(bookIds);
    }
}
