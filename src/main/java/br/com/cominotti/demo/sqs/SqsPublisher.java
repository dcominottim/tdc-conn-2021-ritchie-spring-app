package br.com.cominotti.demo.sqs;

import br.com.cominotti.demo.domain.EventMessage;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SqsPublisher {

    private final QueueMessagingTemplate queueMessagingTemplate;

    private final String queue;

    public SqsPublisher(
            final @Value("${sqs.queue}") String queue,
            final QueueMessagingTemplate queueMessagingTemplate
    ) {
        this.queue = queue;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void send(EventMessage msg) {
        queueMessagingTemplate.convertAndSend(queue, msg);
    }
}
