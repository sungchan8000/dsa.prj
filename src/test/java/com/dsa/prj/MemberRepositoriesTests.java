package com.dsa.prj;

import com.dsa.prj.domain.Member;
import com.dsa.prj.repositories.MemberRepository;
import com.dsa.prj.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class MemberRepositoriesTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;



    @Test
    void 전체_조회_테스트() throws Exception {

        log.info("{}", memberService.getAllMemeberList());

    }

    @Test
    void 중복_확인_테스트() throws Exception {
        String email= "csc0726@naver.com";
        Optional<Member> getMember = memberRepository.findByMemMail(email);
        if(getMember.isPresent()) {
            log.info("FIND MEMBER..{}",getMember.get().getMemId());
        } else {
            log.info("NONE MEMBER..");
        }
    }

    @Test
    void 회원저장_테스트() throws Exception {
        Member member = Member.builder()
                .memName("신중수")
                .memMail("csc0726@naver.com")
                .memPassword("gtest")
                .memPhone("01027553055")
                .memId("csc0726")
                .createDate(LocalDateTime.now())
                .build();

        memberRepository.save(member);
    }

    @Test
    void 회원리스트_조회_테스트() throws Exception {

        List<Member> membres = memberRepository.findAll();

        for(Member member : membres) {
            System.out.println(member.getCreateDate());
        }
    }
}
