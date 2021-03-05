package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.sava(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(
                new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "item1", 1000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}