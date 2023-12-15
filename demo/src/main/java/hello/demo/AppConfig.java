package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService OrderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
