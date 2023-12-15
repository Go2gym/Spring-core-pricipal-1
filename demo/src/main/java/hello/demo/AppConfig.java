package hello.demo;

import hello.demo.discount.FixDiscountPolicy;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

public class AppConfig {
    
    public MemberService MemberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService OrderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
