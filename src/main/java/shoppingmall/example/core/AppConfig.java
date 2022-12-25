package shoppingmall.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shoppingmall.example.core.discount.DiscountPolicy;
import shoppingmall.example.core.discount.FixDiscountPolicy;
import shoppingmall.example.core.member.*;
import shoppingmall.example.core.order.Order;
import shoppingmall.example.core.order.OrderService;
import shoppingmall.example.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
