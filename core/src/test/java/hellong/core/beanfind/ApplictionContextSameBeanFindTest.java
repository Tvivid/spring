package hellong.core.beanfind;

import hellong.core.AppConfig;
import hellong.core.discount.DiscountPolicy;
import hellong.core.member.MemberRepository;
import hellong.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplictionContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate(){
        ac.getBean(DiscountPolicy.class);
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }


}
