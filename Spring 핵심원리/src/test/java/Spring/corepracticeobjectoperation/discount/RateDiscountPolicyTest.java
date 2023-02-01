package Spring.corepracticeobjectoperation.discount;

import Spring.corepracticeobjectoperation.member.Grade;
import Spring.corepracticeobjectoperation.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void success() {
        //given
        Member member = new Member(1L, "A", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP는 10% 할인이 적용되지 않아야한다.")
    void fail(){
        //given
        Member member = new Member(1L, "A", Grade.Basic);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}