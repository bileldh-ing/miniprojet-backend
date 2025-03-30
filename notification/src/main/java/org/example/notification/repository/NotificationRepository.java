package org.example.notification.repository;

import org.example.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Custom query method to find notifications containing the professor's name
    List<Notification> findByMessageContainingIgnoreCase(String professorName);
}