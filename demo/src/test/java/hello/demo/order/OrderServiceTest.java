package hello.demo.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.demo.AppConfig;
import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.MemberService();
        orderService = appConfig.OrderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
