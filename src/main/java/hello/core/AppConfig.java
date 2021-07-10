package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository()); // memberService가 발생하면 implement가 만들어지면서 그때 MemoryMemberRepository를 주입한 뒤 넘겨줌
    }

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    
}
