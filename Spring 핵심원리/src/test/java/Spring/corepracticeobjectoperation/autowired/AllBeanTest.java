package Spring.corepracticeobjectoperation.autowired;

import Spring.corepracticeobjectoperation.AppConfig;
import Spring.corepracticeobjectoperation.discount.DiscountPolicy;
import Spring.corepracticeobjectoperation.member.Grade;
import Spring.corepracticeobjectoperation.member.Member;
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "rateDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    }

    static class DiscountService{
        private  final Map<String, DiscountPolicy> policyMap;
        private  final List<DiscountPolicy> policyList;
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList){
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }
        //discountCode에 어떤 할인 정책을 사용할 것인지 넘겨주면 해당 할인 정책에 맞춰 계산해준다.
        //클라이언트가 어떤 할인 정책을 사용할 것인지 고를 수 있는 로직
        public int discount(Member member, int i, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, i);
        }
    }
}
