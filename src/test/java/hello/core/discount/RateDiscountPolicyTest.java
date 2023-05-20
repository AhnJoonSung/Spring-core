package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discountPrice = rateDiscountPolicy.discount(member, 10_000);

        //then
        assertThat(discountPrice).isEqualTo(1_000);
    }

    @Test
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        //when
        int discountPrice = rateDiscountPolicy.discount(member, 10_000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}