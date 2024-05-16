package xyz.solidnetwork.service.account;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.slf4j.MDC;
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

    private static final int SLEEP_TIME = 1000;

    public Report getReport() {

        Map<String, String> mdcContextMap = MDC.getCopyOfContextMap();

        Thread producerTask = new Thread(() -> {
            MDC.setContextMap(mdcContextMap);
            log.info("microservice transaction-service called through fifo queue");

            Request request = new Request();
            request.setId(UUID.randomUUID().toString());
            producer.send(request);
        });
        producerTask.start();

        try {

            return CompletableFuture.supplyAsync(() -> {
                MDC.setContextMap(mdcContextMap);
                log.info("microservice transaction-service answered through fifo queue");

                try {
                    log.info("sleep {} microseconds before call the queue", SLEEP_TIME);
                    Thread.sleep(SLEEP_TIME);
                } catch (Throwable ex) {
                    log.error("error while sleep before to call fifo queue", ex);

                    return new Report();
                }

                Report report = consumer.receive();

                log.info("report from queue {}", report);

                return report;

            }).exceptionally((throwable) -> {

                log.error("response from fifo queue", throwable);

                return new Report();

            }).get();

        } catch (Throwable e) {
            log.error("error processing call to fifo queue", e);

            return new Report();
        }

    }

}
