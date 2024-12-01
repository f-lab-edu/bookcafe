package com.study.bookcafe.dto;

import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Inventory;
import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    /*
        1. 재고 관리
        2. 대출 권수 관리
        3. 대출 내역 관리
     */

    private long id;                    // 도서 번호
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
    private Inventory inventory;            // 도서 상태 정보 (재고, 대출, 예약)

    // BookDTO to Book
    public Book toDomain() {
        return Book.builder()
                .id(this.getId())
                .ISBN(this.getISBN())
                .title(this.getTitle())
                .author(this.getAuthor())
                .publisher(this.getPublisher())
                .publishDate(this.getPublishDate())
                .price(this.getPrice())
                .inventory(this.getInventory())
                .build();
    }

    // Book to BookDTO
    public static BookDto from(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .ISBN(book.getISBN())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publishDate(book.getPublishDate())
                .price(book.getPrice())
                .inventory(book.getInventory())
                .build();
    }


}

