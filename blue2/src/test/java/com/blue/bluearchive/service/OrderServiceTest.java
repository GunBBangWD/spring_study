package com.blue.bluearchive.service;

import com.blue.bluearchive.constant.ItemSellStatus;
import com.blue.bluearchive.constant.OrderStatus;
import com.blue.bluearchive.shop.dto.OrderDto;
import com.blue.bluearchive.shop.entity.Item;
import com.blue.bluearchive.member.entity.Member;
import com.blue.bluearchive.shop.entity.Order;
import com.blue.bluearchive.shop.entity.OrderItem;
import com.blue.bluearchive.shop.repository.ItemRepository;
import com.blue.bluearchive.member.repository.MemberRepository;
import com.blue.bluearchive.shop.repository.OrderRepository;
import com.blue.bluearchive.shop.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Item saveItem()
    {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        return itemRepository.save(item);
    }

    public Member saveMember()
    {
        Member member = new Member();
        member.setEmail("test@test.com");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("주문 테스트")
    public void order()
    {
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());
        Long orderId = orderService.order(orderDto, member.getEmail());
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        List<OrderItem> orderItems = order.getOrderItems();
        int totalPrice = orderDto.getCount()*item.getPrice();

        assertEquals(totalPrice, order.getTotalPrice());

    }

    @Test
    @DisplayName("주문 취소 테스트")
    public void cancelOrder()
    {
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());
        Long orderId = orderService.order(orderDto, member.getEmail());

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        orderService.cancelOrder(orderId);

        Assertions.assertEquals(OrderStatus.CANCEL, order.getOrderStatus());

    }



}