package Spring.corepracticeobjectoperation;

import Spring.corepracticeobjectoperation.discount.DiscountPolicy;
import Spring.corepracticeobjectoperation.discount.FixDiscountPolicy;
import Spring.corepracticeobjectoperation.discount.RateDiscountPolicy;
import Spring.corepracticeobjectoperation.order.OrderService;
import Spring.corepracticeobjectoperation.order.OrderServiceImpl;
import Spring.corepracticeobjectoperation.repository.MemberRepository;
import Spring.corepracticeobjectoperation.repository.MemoryMemberRepository;
import Spring.corepracticeobjectoperation.service.MemberService;
import Spring.corepracticeobjectoperation.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
