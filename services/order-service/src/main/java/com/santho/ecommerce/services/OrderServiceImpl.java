package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.*;
import com.santho.ecommerce.exceptions.OrderException;
import com.santho.ecommerce.feigns.CustomerFeign;
import com.santho.ecommerce.feigns.ProductFeign;
import com.santho.ecommerce.kafka.OrderProducer;
import com.santho.ecommerce.mappers.OrderMapper;
import com.santho.ecommerce.models.Order;
import com.santho.ecommerce.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final CustomerFeign customerFeign;
    private final ProductFeign productFeign;
    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final OrderProducer producer;

    @Override
    public ResponseEntity<Integer> createOrder(OrderRequestDto request) {
        ResponseEntity<?> customerResponse = customerFeign.findById(request.getCustomerId());
        if(customerResponse.getStatusCode().isError())
            throw new OrderException(customerResponse.getBody().toString());
        CustomerResponseDto customer = (CustomerResponseDto) customerResponse.getBody();

        ResponseEntity<?> purchaseResponse = productFeign.purchaseProducts(request.getProducts());
        if(purchaseResponse.getStatusCode().isError())
            throw new OrderException(customerResponse.getBody().toString());

        Order order = orderRepository.save(OrderMapper.toOrder(request));

        request.getProducts().forEach(
                op -> {
                    orderProductService.add(OrderProductRequestDto.builder()
                            .orderId(order.getId())
                            .productId(op.getProductId())
                            .quantity(op.getQuantity())
                            .build());
                });

        //todo Payment Pending

        //todo Kafka Notification Send to User
        producer.sendOrderConfirmation(OrderResponseDto
                .builder()
                .id(order.getId())
                .customerResponseDto(customer)
                .paymentMethod(order.getPaymentMethod())
                .purchase((List<PurchaseResponseDto>) purchaseResponse.getBody())
                .totalAmount(order.getAmount())
                .build());
        return null;
    }
}
