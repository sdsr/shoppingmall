package shoppingmall.example.core.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shoppingmall.example.core.member.Grade;
import shoppingmall.example.core.member.Member;
import shoppingmall.example.core.member.MemberService;
import shoppingmall.example.core.member.MemberServiceImpl;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "MemberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
