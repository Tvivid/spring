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

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
