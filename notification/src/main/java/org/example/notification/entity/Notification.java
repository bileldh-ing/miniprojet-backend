package org.example.notification.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime dateEnvoi;

    public Notification() {}

    public Notification(String message) {
        this.message = message;
        this.dateEnvoi = LocalDateTime.now();

    }

    // Getters et setters
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public LocalDateTime getDateEnvoi() { return dateEnvoi; }


}
