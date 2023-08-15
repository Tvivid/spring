package hellong.core.order;

import hellong.core.discount.FixDiscountPolicy;
import hellong.core.member.Grade;
import hellong.core.member.Member;
import hellong.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {




    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository =new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order =orderService.createOrder(1L,"itemA",10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}