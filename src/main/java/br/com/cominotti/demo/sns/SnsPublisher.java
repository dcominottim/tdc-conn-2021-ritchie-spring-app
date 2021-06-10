package br.com.cominotti.demo.sns;

import br.com.cominotti.demo.domain.EventMessage;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SnsPublisher {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    private final String snsTopic = "test-topic";

    public void send(EventMessage msg) {
        this.notificationMessagingTemplate.sendNotification(snsTopic, msg, "subject");
    }
}
