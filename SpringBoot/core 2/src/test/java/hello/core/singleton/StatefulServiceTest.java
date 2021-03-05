package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {


    @Test
    @DisplayName("싱글톤 주의 할 점")
    void statefulServiceSingletion(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

       int price =  statefulService1.order("sydal", 22000);
        int price2 =statefulService2.order("dong", 42000);

        System.out.println("price = " + price);


        Assertions.assertThat(price2).isEqualTo(42000);


    }

    static class  TestConfig{

        @Bean
        public  StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
