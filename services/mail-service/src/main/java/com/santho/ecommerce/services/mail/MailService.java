package com.santho.ecommerce.services.mail;

import com.santho.ecommerce.dtos.order.OrderResponseDto;
import com.santho.ecommerce.dtos.payment.PaymentNotificationRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static com.santho.ecommerce.models.EmailTemplates.ORDER_EMAIL;
import static com.santho.ecommerce.models.EmailTemplates.PAYMENT_EMAIL;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentMail(PaymentNotificationRequest request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());
        mimeMessageHelper.setFrom("prolaboffl@gmail.com");

        Map<String, Object> variables = new HashMap<>();
        variables.put("customer-name", request.getFirstName());
        variables.put("amount", request.getAmount().toEngineeringString());
        variables.put("payment-Id", request.getId());
        variables.put("order-id", request.getOrderId());

        Context context = new Context();
        context.setVariables(variables);
        mimeMessageHelper.setSubject(PAYMENT_EMAIL.getSubject());

        try {
            String htmlTemplate = templateEngine.process(PAYMENT_EMAIL.getTemplate(), context);
            mimeMessageHelper.setText(htmlTemplate, true);
            mimeMessageHelper.setTo(request.getEmail());

            mailSender.send(mimeMessage) ;
        }
        catch (MessagingException ex){
            log.error("ERROR sending in email");
        }
    }

    @Async
    public void sendOrderMail(OrderResponseDto request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());
        mimeMessageHelper.setFrom("prolaboffl@gmail.com");

        Map<String, Object> variables = new HashMap<>();
        variables.put("customer-name", request.getCustomerResponseDto().getFirstName());
        variables.put("amount", request.getTotalAmount());
        variables.put("order-Id", request.getId());
        variables.put("products", request.getPurchase());

        Context context = new Context();
        context.setVariables(variables);
        mimeMessageHelper.setSubject(ORDER_EMAIL.getSubject());

        try {
            String htmlTemplate = templateEngine.process(PAYMENT_EMAIL.getTemplate(), context);
            mimeMessageHelper.setText(htmlTemplate, true);
            mimeMessageHelper.setTo(request.getCustomerResponseDto().getEmail());

            mailSender.send(mimeMessage) ;
        }
        catch (MessagingException ex){
            log.error("ERROR sending in email to {}", request.getCustomerResponseDto().getEmail());
        }
    }
}
