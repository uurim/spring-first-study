package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.GenericArrayType;

public class xmlAppContext {

    @Test
    void xmlAppContext() {
        //ApplicationContext는 GenericXmlApplicationContext의 부모
        ApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
