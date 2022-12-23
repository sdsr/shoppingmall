package shoppingmall.example.core;

import shoppingmall.example.core.member.Grade;
import shoppingmall.example.core.member.Member;
import shoppingmall.example.core.member.MemberService;
import shoppingmall.example.core.member.MemberServiceImpl;
import shoppingmall.example.core.order.Order;
import shoppingmall.example.core.order.OrderService;
import shoppingmall.example.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
