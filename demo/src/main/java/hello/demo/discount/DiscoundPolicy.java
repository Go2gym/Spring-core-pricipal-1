package hello.demo.discount;

import hello.demo.member.Member;

public interface DiscoundPolicy {
    
    /*
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
