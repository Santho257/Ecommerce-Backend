package com.santho.ecommerce.services.kafka;

import com.santho.ecommerce.dtos.order.OrderResponseDto;
import com.santho.ecommerce.dtos.payment.PaymentNotificationRequest;
import com.santho.ecommerce.models.Notification;
import com.santho.ecommerce.models.NotificationType;
import com.santho.ecommerce.repository.NotificationRepository;
import com.santho.ecommerce.services.mail.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;
    private final MailService mailService;

    @KafkaListener(topics = "order-topic", groupId = "orderGroup")
    public void consumeOrder(OrderResponseDto order) throws MessagingException {
        log.info("Consuming data from order-topic :: {}", order);
        notificationRepository.save(Notification.builder()
                .notificationType(NotificationType.ORDER_NOTIFICATION)
                .order(order)
                .build());
        mailService.sendOrderMail(order);
    }

    @KafkaListener(topics = "payment-topic", groupId = "paymentGroup")
    public void consumePayment(PaymentNotificationRequest payment) throws MessagingException {
        log.info("Consuming data from payment-topic :: {}", payment);
        notificationRepository.save(Notification.builder()
                .notificationType(NotificationType.PAYMENT_NOTIFICATION)
                .payment(payment)
                .build());
        mailService.sendPaymentMail(payment);
    }

}
