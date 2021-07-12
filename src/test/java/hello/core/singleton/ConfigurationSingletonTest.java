package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
 
    
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        
        OrderServiceImpl orderService1 = ac.getBean("orderService", OrderServiceImpl.class);


        MemberRepository memberRepository1 = memberService1.getMemberRepository();
        MemberRepository memberRepository2 = orderService1.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1 
                        +"\n" + " orderService -> memberRepository = " + memberRepository2);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        
        System.out.println("bean = " + bean.getClass()); // class hello.core.AppConfig$$EnhancerBySpringCGLIB$$6de16f1b

        
    }
}
