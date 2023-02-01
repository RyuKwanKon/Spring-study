package Spring.corepracticeobjectoperation.order;

import Spring.corepracticeobjectoperation.discount.DiscountPolicy;
import Spring.corepracticeobjectoperation.discount.FixDiscountPolicy;
import Spring.corepracticeobjectoperation.discount.RateDiscountPolicy;
import Spring.corepracticeobjectoperation.member.Member;
import Spring.corepracticeobjectoperation.repository.MemberRepository;
import Spring.corepracticeobjectoperation.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //단일체계원칙을 잘지킨 것이다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
