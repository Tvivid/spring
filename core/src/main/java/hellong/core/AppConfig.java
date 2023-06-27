package hellong.core;

import hellong.core.discount.FixDiscountPolicy;
import hellong.core.member.MemberService;
import hellong.core.member.MemberServiceImpl;
import hellong.core.member.MemoryMemberRepository;
import hellong.core.order.OrderService;
import hellong.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }



}
