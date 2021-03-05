package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("vip")
    void vip(){
        Member member = new Member(1L, "membervip", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아니면 할인 안됨")
    void vip_x(){
        Member member = new Member(1L, "membervip", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isNotEqualTo(1000);
    }

}