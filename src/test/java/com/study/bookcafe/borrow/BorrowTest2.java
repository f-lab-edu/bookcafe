package com.study.bookcafe.borrow;

import com.study.bookcafe.borrow.application.command.borrow.BorrowService;
import com.study.bookcafe.borrow.application.event.BorrowEvent;
import com.study.bookcafe.reservation.application.event.BorrowEventListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

@SpringBootTest
public class BorrowTest2 {
    private BorrowService borrowService;

    @MockBean
    private BorrowEventListener borrowEventListener;

//    @Autowired
//    ApplicationContext applicationContext;

    @Mock
    ApplicationEventPublisher applicationEventPublisher;

    @Test
    @DisplayName("대출할 때, 우선대출예약이었다면 예약은 삭제한다.")
    public void borrowAndDeletePriorityBorrowReservation() {

        // given (Mock 설정)
        long memberId = 1;
        long bookId = 1;
        BorrowEvent event = new BorrowEvent(memberId, bookId);

        // when (테스트 실행)
        applicationEventPublisher.publishEvent(event);

        // then (결과 검증)
        verify(borrowEventListener).deletePriorityBorrowReservation(event);
    }
}
