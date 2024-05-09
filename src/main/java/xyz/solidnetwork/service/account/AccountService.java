package xyz.solidnetwork.service.account;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.account.transaction.Report;
import xyz.solidnetwork.service.account.transaction.Request;
import xyz.solidnetwork.service.aws.sqs.Consumer;
import xyz.solidnetwork.service.aws.sqs.Producer;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    public Report getReport() {

        log.info("microservice transaction-service is through fifo queue");

        producer.send(new Request(UUID.randomUUID().toString()));

       return consumer.getReport();

    }

}
