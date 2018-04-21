package com.willstay.springbootetl.messagesender;

import org.springframework.stereotype.Component;

@Component
public class RabbitConfig {
    public static final String exchangeName = "etl.status";
    public static final String routingKey = "etl.willstay.";
    public static final String routingTrucksKey = "etl.willstay.trucks";
    public static final String routingSuvsKey = "etl.willstay.suvs";
    public static final String queueTrucksName = "trucks";
    public static final String queueSuvsName = "suvs";

}
