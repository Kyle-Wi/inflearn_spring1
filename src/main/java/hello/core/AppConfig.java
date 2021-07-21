package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService()");
        return new MemberServiceImpl(MemberRepository()); // memberService가 발생하면 implement가 만들어지면서 그때 MemoryMemberRepository를 주입한 뒤 넘겨줌
    }

    @Bean
    public MemoryMemberRepository MemberRepository() {
        System.out.println("call AppConfig.MemberRepository()");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService()");
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    @Primary
    public DiscountPolicy discountPolicy(){
        System.out.println("call AppConfig.discountPolicy()");
        return new RateDiscountPolicy();
    }
    
}
