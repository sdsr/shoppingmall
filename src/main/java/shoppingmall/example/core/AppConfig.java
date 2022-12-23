package shoppingmall.example.core;

import shoppingmall.example.core.discount.DiscountPolicy;
import shoppingmall.example.core.discount.FixDiscountPolicy;
import shoppingmall.example.core.member.*;
import shoppingmall.example.core.order.Order;
import shoppingmall.example.core.order.OrderService;
import shoppingmall.example.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
