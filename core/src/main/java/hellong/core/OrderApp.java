package hellong.core;

import hellong.core.member.Grade;
import hellong.core.member.Member;
import hellong.core.member.MemberService;
import hellong.core.member.MemberServiceImpl;
import hellong.core.order.Order;
import hellong.core.order.OrderService;
import hellong.core.order.OrderServiceImpl;

public class OrderApp {


    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice  = " + order.calculatePrice());
    }
}
