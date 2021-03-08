package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeBeanTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(PrototypeBean.class);


        PrototypeBean PrototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean PrototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("PrototypeBean2 = " + PrototypeBean2);
        System.out.println("PrototypeBean1 = " + PrototypeBean1);

        ac.close();

    }





    @Scope("prototype")
    static  class  PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }}

