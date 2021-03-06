package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepositoryOld memberRepositoryOld;
    @Autowired
    MemberService memberService;

    @Test
    public void joinMember() throws Exception{
        // given
        Member member = new Member();
        member.setName("AAA");

        // when
        Long saveId = memberService.join(member);

        // then
        assertEquals(member, memberRepositoryOld.findOne(saveId));
    }

    @Test()
    public void doubleMember() throws Exception{
        // given
        Member member1 = new Member();
        member1.setName("AAA");

        Member member2 = new Member();
        member2.setName("AAA");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
        fail("예외가 발생하지 않았습니다.");
    }
}