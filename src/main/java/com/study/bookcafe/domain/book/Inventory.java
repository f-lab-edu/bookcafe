package com.study.bookcafe.domain.book;

import lombok.Getter;

@Getter
public class Inventory {
    private int stock;                      // 재고
    private int borrowed;                   // 대출 중인 권수

    public Inventory(int stock) {
        this.stock = stock;
        this.borrowed = 0;
    }

    public boolean isOnStock() {
        return stock - borrowed > 0;
    }
}
