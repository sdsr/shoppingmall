package shoppingmall.example.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import shoppingmall.example.core.member.Grade;
import shoppingmall.example.core.member.Member;

@Component
//  @Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixAmount;
        else {
            return 0;
        }
    }
}
