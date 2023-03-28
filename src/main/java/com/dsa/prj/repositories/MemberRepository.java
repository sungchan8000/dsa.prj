package com.dsa.prj.repositories;

import com.dsa.prj.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemId(String memId);
    Optional<Member> findByMemMail(String memEmail);
    Optional<Member> findByMemPhone(String memPhoneNumber);

    Optional<Member> findByMemMailAndMemName(String memMail, String memName);

}
