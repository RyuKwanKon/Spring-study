package Spring.corepracticeobjectoperation.order;

import Spring.corepracticeobjectoperation.AppConfig;
import Spring.corepracticeobjectoperation.discount.RateDiscountPolicy;
import Spring.corepracticeobjectoperation.member.Grade;
import Spring.corepracticeobjectoperation.member.Member;
import Spring.corepracticeobjectoperation.service.MemberService;
import Spring.corepracticeobjectoperation.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId, "item", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        //then
    }
}
