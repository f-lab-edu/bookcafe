package com.study.bookcafe.domain.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Value;
import java.sql.Date;

@Value
@Builder
public class Book {
    @Positive(message = "잘못된 ISBN 입니다.")
    @NotNull(message = "ISBN은 필수 값입니다.")
    long ISBN;                      // 국제표준도서번호
    @NotBlank(message = "도서명은 필수 값입니다.")
    String title;                   // 도서 명
    @NotBlank(message = "저자명은 필수 값입니다.")
    String author;                  // 저자 명
    String translator;              // 역자 명
    @NotBlank(message = "출판사명은 필수 값입니다.")
    String publisher;               // 출판사 명
    @NotNull(message = "출판일은 필수 값입니다.")
    Date publishDate;               // 출판일
    @Positive(message = "잘못된 도서 가격입니다.")
    int price;                      // 도서 가격
}
