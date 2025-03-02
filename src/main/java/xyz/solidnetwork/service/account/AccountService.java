package xyz.solidnetwork.service.account;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.aws.sqs.Consumer;
import xyz.solidnetwork.service.aws.sqs.Producer;
import xyz.solidnetwork.service.aws.sqs.Request;
import xyz.solidnetwork.service.transaction.Report;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    public Report getReport() {

        log.info("microservice transaction-service called through fifo queue");

        Request request = new Request();
        request.setId(UUID.randomUUID().toString());
        producer.send(request);

        log.info("microservice transaction-service answered through fifo queue");

        return consumer.receive().getReport();

    }

}
