package com.study.bookcafe.controller;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.dto.BorrowDto;
import com.study.bookcafe.dto.MemberDto;
import com.study.bookcafe.dto.RequestBorrowDto;
import com.study.bookcafe.mapper.BorrowMapper;
import com.study.bookcafe.mapper.MemberMapper;
import com.study.bookcafe.service.MemberService;
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
        List<Borrow> borrowList = memberService.borrowBook(requestBorrowDto.getMemberId(), requestBorrowDto.getBookdIdList());
        return ResponseEntity.ok(borrowMapper.toBorrowDtoList(borrowList));
    }

}
