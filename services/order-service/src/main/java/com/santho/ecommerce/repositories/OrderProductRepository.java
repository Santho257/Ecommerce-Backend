package com.santho.ecommerce.repositories;

import com.santho.ecommerce.models.Order;
import com.santho.ecommerce.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> findByOrderId(Order order);
}
