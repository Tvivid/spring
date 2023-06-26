package hellong.core.order;

import hellong.core.discount.DiscountPolicy;
import hellong.core.discount.FixDiscountPolicy;
import hellong.core.discount.RateDiscountPolicy;
import hellong.core.member.Member;
import hellong.core.member.MemberRepository;
import hellong.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName,itemPrice,discountPrice);
    }
}
