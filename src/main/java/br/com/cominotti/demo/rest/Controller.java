package br.com.cominotti.demo.rest;

import br.com.cominotti.demo.domain.EventMessage;
import br.com.cominotti.demo.sns.SnsPublisher;
import br.com.cominotti.demo.sqs.SqsPublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final SqsPublisher sqsPublisher;

    private final SnsPublisher snsPublisher;

    @RequestMapping(
            path = "/sqs/publish",
            method = RequestMethod.POST
    )
    public void triggerSqsPublish(@RequestBody EventMessage event) {
        sqsPublisher.send(event);
    }

    @RequestMapping(
            path = "/sns/publish",
            method = RequestMethod.POST
    )
    public void triggerSnsPublish(@RequestBody EventMessage event) {
        snsPublisher.send(event);
    }
}
