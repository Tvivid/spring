package hellong.core.autowired;

import hellong.core.AutoAppConfig;
import hellong.core.discount.DiscountPolicy;
import hellong.core.member.Grade;
import hellong.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountPolicy.class);

        DisocuntService disocuntService = ac.getBean(DisocuntService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = disocuntService.discount(member, 10000, "fixDiscountPolicy");
        
    }

    static class DisocuntService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DisocuntService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyMap = " + policies);
        }

        public int discount(Member member, int i, String fixDiscountPolicy) {
            return 0;
        }
    }

}
