package hellong.core;

import hellong.core.discount.DiscountPolicy;
import hellong.core.discount.FixDiscountPolicy;
import hellong.core.discount.RateDiscountPolicy;
import hellong.core.member.MemberRepository;
import hellong.core.member.MemberService;
import hellong.core.member.MemberServiceImpl;
import hellong.core.member.MemoryMemberRepository;
import hellong.core.order.OrderService;
import hellong.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        //return null;
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
