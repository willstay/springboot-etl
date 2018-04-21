package com.willstay.springbootetl.messagesender;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String SUVS_DONE = "suvs done";
    private static final String TRUCKS_DONE = "trucks done";

    public void truckDone() {
        rabbitTemplate.convertAndSend(RabbitConfig.exchangeName,
                RabbitConfig.routingTrucksKey, TRUCKS_DONE);

        log.info(TRUCKS_DONE);
    }

    public void suvsDone() {
        rabbitTemplate.convertAndSend(RabbitConfig.exchangeName,
                RabbitConfig.routingSuvsKey, SUVS_DONE);
        log.info(SUVS_DONE);
    }
}
