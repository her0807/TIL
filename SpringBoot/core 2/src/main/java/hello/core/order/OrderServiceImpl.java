package hello.core.order;

import hello.core.annotation.MainDiscountPoilcy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;


//  @RequiredArgsConstructor가 아래와 같은 생성자를 대신해서 만들어줌
    @Autowired //생성할 때 자동으로 의존관계를 설정해줌.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPoilcy DiscountPolicy
           rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

