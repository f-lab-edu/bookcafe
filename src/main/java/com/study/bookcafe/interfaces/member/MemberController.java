package com.study.bookcafe.interfaces.member;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.interfaces.borrow.RequestBorrowDto;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import com.study.bookcafe.application.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;
    private final BorrowMapper borrowMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper, BorrowMapper borrowMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.borrowMapper = borrowMapper;
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity<MemberDto> member(@PathVariable long id) {
        Member member = memberService.findById(id);
        return ResponseEntity.ok(memberMapper.toMemberDto(member));
    }

    @PostMapping("/member/borrow")
    @ResponseBody
    public ResponseEntity<List<BorrowDto>> borrowBook(@RequestBody RequestBorrowDto requestBorrowDto) {
        List<Borrow> borrows = memberService.borrowBook(requestBorrowDto.getMemberId(), requestBorrowDto.getBookdIdList());
        return ResponseEntity.ok(borrowMapper.toBorrowDtoList(borrows));
    }

}
