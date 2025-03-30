package org.example.notification.testproducerasupprimer.ProducerController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final AmqpTemplate amqpTemplate;

    // Inject AmqpTemplate to send messages
    public ProducerController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping("/send")
    public String sendMessage() {
        // Create a sample message
        String message = "le date de soutenance est le 29/07/2025 le prof : semi , salle : M19 ,temp:15:00 ";

        // Send message to the queue 'notificationQueue'
        amqpTemplate.convertAndSend("notificationQueue", message);

        return "Message sent to the queue: " + message;
    }

}
