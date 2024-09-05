package com.santho.ecommerce.repository;

import com.santho.ecommerce.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
