package com.dsa.prj;

import com.dsa.prj.controller.MemberController;
import com.dsa.prj.domain.Member;
import com.dsa.prj.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MemberRepository memberRepository;



    @Test
    public void 회원정보_조회_테스트() throws  Exception {
        Member member = Member.builder()
                .memName("최성찬")
                .memMail("csc0726@naver.com")
                .memPassword("gtest")
                .memId("csc0726")
                .createDate(LocalDateTime.now())
                .build();
        memberRepository.save(member);
    }


    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        HashMap<String, Objects> hashMap = new HashMap<>();

        mvc.perform(MockMvcRequestBuilders.get("/member/list"))
                .andExpect(status().isOk());
    }


}
