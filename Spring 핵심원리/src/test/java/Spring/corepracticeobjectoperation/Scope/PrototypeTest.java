package Spring.corepracticeobjectoperation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("singleton1 = " + prototypeBean1);
        System.out.println("singleton2 = " + prototypeBean2);
        prototypeBean1.destroy();
        prototypeBean2.destroy();
        ac.close();
    }
    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("Prototype.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("Prototype.destroy");
        }

    }
}
