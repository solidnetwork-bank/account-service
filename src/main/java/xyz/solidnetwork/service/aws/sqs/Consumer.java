package xyz.solidnetwork.service.aws.sqs;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.account.transaction.Report;

@Service
@Slf4j
public class Consumer {

    @SqsListener(value = "${aws.transaction.response.queue.name}")
    public void listen(Report report, @Headers Map<String, String> headers) {
        log.info("messageFromQueue={} headers={}", report, headers);

    }

    public Report getReport(){
        return new Report();
    }

}