package shoppingmall.example.core.order;

import ch.qos.logback.core.joran.util.PropertySetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingmall.example.core.discount.DiscountPolicy;
import shoppingmall.example.core.discount.FixDiscountPolicy;
import shoppingmall.example.core.discount.RateDiscountPolicy;
import shoppingmall.example.core.member.Member;
import shoppingmall.example.core.member.MemberRepository;
import shoppingmall.example.core.member.MemberService;
import shoppingmall.example.core.member.MemoryMemberRepository;

import java.util.Set;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy;

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    @Autowired // 선택적으로 의존관계 주입(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }

    //    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
    @Autowired//생성자가 하나일때는 자동으로 Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
