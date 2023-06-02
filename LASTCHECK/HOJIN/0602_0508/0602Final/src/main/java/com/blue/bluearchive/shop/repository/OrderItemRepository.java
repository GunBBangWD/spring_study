package com.blue.bluearchive.shop.repository;

import com.blue.bluearchive.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    @Query("SELECT SUM(oi.orderPrice * oi.count) FROM OrderItem oi " +
            "JOIN oi.order o " +
            "JOIN o.member m " +
            "WHERE m.email = :email " +
            "AND o.orderStatus = 'ORDER'")
    Integer calculateOrderTotalPriceByEmail(@Param("email") String email);
}
