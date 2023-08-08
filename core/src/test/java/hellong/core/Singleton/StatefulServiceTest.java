package hellong.core.Singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {



    @Test
    void StatefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);

        //객체 두개 생성
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //userA가 만원 주문
        int userAPrice = statefulService1.order("userA",10000);

        //userB가 2만원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //조회 만원이찍혀야함.
//        int price = statefulService1.getPrice();

        //2만원 찍힘.
        System.out.println("price = " + userAPrice);

        //테스트 마무리를 위한 코드.
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }



    static class Testconfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}