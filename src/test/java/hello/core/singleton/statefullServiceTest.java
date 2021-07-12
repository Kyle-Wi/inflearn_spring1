package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class statefullServiceTest {

    @Test
    void statfullServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullService statefullService1 = ac.getBean(StatefullService.class);
        StatefullService statefullService2 = ac.getBean(StatefullService.class);

        //Thread A : A 사용자 1000원 주문
        int priceA = statefullService1.order("userA", 1000);
        //Thread B : B 사용자 2000원 주문
        int priceB = statefullService2.order("userB", 2000);

        // Thread A: A 사용자가 주문 금액 조회
        System.out.println("priceA = " + priceA);
        // Thread B: B 사용자가 주문 금액 조회 // 기대값 2000원
        System.out.println("priceB = " + priceB);

        Assertions.assertThat(priceA).isEqualTo(2000);
    }

    static class TestConfig{

        @Bean
        public StatefullService statefullService(){
            return new StatefullService();
        }
    }
    

}
    