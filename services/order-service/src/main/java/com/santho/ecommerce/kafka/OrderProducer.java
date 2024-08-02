package com.santho.ecommerce.kafka;

import com.santho.ecommerce.dtos.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, OrderResponseDto> kafkaTemplate;
    public void sendOrderConfirmation(OrderResponseDto orderResponse){
        Message<OrderResponseDto> message = MessageBuilder
                .withPayload(orderResponse)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
