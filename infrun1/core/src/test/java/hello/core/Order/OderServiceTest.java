package hello.core.Order;

import hello.core.member.*;
import hello.core.order.OderService;
import hello.core.order.OderServiceImpl;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OderService oderService = new OderServiceImpl();
    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId,"member1",Grade.VIP);
        memberService.join(member);
        Order order = oderService.createOrder(memberId, "item1",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
