package hello.demo.order;

import hello.demo.AppConfig;
import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.OrderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.caculatePrice = " + order.calculatePrice());
    }
}