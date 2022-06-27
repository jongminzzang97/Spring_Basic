package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoriMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoriMemberRepository();

    // 마친가지로 여기서 코드를 수정을 통해 할인정책을 바꿔야하는 것은 불편하다.
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long MemberId, String itemName, int itemPrice) {
        Member member = memberRepository.findyById(MemberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(MemberId, itemName, itemPrice, discountPrice);
    }
}
