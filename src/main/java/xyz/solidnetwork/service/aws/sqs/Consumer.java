package xyz.solidnetwork.service.aws.sqs;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {

    @Autowired
    private SqsTemplate sqsTemplate;

    @Value("${aws.transaction.response.queue.name}")
    private String queueName;

    public Response receive() {

        Optional<Message<Response>> receivedMessage = sqsTemplate
                .receive(from -> from.queue(queueName)
                        .maxNumberOfMessages(1)
                        .visibilityTimeout(Duration.ofSeconds(10))
                        .pollTimeout(Duration.ofSeconds(5))
                        .receiveRequestAttemptId(UUID.randomUUID()),
                        Response.class);

        log.info("message receive from queue {}", receivedMessage);

        return receivedMessage.get().getPayload();

    }

}