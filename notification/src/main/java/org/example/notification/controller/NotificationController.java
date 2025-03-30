package org.example.notification.controller;

import org.example.notification.entity.Notification;
import org.example.notification.repository.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    // New method to get notifications by professor's name
    @GetMapping("/professor/{professorName}")
    public List<Notification> getNotificationsByProfessor(@PathVariable String professorName) {
        return notificationRepository.findByMessageContainingIgnoreCase("prof : "+professorName);
    }
}
