package hello.demo.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.demo.discount.FixDiscountPolicy;
import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void testCreateOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl OrderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        Order order = OrderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void testGetMemberRepository() {

    }
}
