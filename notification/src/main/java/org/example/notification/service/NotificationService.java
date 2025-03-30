package org.example.notification.service;
import org.example.notification.entity.Notification;
import org.example.notification.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @RabbitListener(queues = "notificationQueue")
    public void receiveMessage(String message) {
        Notification notification = new Notification(message);
        notificationRepository.save(notification); // Enregistrer dans la base
    }

}
