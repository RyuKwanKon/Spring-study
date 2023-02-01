package Spring.corepracticeobjectoperation.discount;

import Spring.corepracticeobjectoperation.member.Grade;
import Spring.corepracticeobjectoperation.member.Member;

import java.util.Dictionary;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
