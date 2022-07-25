package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수 자바 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너")
    void singletonContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //2. 조회 : 호출할 때마다 같은 객체 호출
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
//        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        // 이 경우는 같아야 함
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }


}
