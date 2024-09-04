package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.*;
import com.santho.ecommerce.exceptions.OrderException;
import com.santho.ecommerce.feigns.CustomerFeign;
import com.santho.ecommerce.feigns.PaymentFeign;
import com.santho.ecommerce.feigns.ProductFeign;
import com.santho.ecommerce.kafka.OrderProducer;
import com.santho.ecommerce.mappers.OrderMapper;
import com.santho.ecommerce.models.Order;
import com.santho.ecommerce.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final CustomerFeign customerFeign;
    private final ProductFeign productFeign;
    private final PaymentFeign paymentFeign;
    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final OrderProducer producer;

    @Override
    public Integer createOrder(OrderRequestDto request) {
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
        paymentFeign.create(PaymentRequestDto.builder()
                        .amount(request.getAmount())
                        .paymentMethod(request.getPaymentMethod())
                        .customer(customer)
                        .orderId(order.getId())
                .build());

        producer.sendOrderConfirmation(OrderMapper.toOrderResponse(order, customer,
                (List<PurchaseResponseDto>) purchaseResponse.getBody()));
        return null;
    }

    @Override
    public List<OrderResponseGlobalDto> getOrders() {
        return orderRepository.findAll().stream().map(OrderMapper::toGlobalOrderResponse).toList();
    }

    @Override
    public OrderResponseGlobalDto getOrderById(Integer id) {
        return orderRepository.findById(id)
                .map(OrderMapper::toGlobalOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException("Order Not found with ID: " + id));
    }
}
