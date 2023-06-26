package hellong.core.discount;

import hellong.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
