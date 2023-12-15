package hello.demo.order;

import hello.demo.discount.DiscoundPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscoundPolicy discountPolicy;
    
    public OrderServiceImpl(MemberRepository memberRepository, DiscoundPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}