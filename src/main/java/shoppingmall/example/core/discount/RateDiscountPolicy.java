package shoppingmall.example.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import shoppingmall.example.core.annotation.MainDiscountPolicy;
import shoppingmall.example.core.member.Grade;
import shoppingmall.example.core.member.Member;

@Component
@MainDiscountPolicy
//@Primary
//@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
