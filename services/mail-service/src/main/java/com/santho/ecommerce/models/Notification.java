package com.santho.ecommerce.models;

import com.santho.ecommerce.dtos.order.OrderResponseDto;
import com.santho.ecommerce.dtos.payment.PaymentNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@EnableMongoAuditing
public class Notification {
    @Id
    private String id;
    private NotificationType notificationType;
    @CreatedDate
    private LocalDateTime notificationSentTime;
    private OrderResponseDto order;
    private PaymentNotificationRequest payment;
}



