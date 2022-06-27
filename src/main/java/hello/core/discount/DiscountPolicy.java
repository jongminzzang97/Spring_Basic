package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 금액 (할인 후의 물건 금액 아님)
     */
    int discount(Member member, int price);
}
