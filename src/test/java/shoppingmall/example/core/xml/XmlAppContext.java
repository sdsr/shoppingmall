package shoppingmall.example.core.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import shoppingmall.example.core.member.MemberService;

public class XmlAppContext {

    @Test
    void XmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appconfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
