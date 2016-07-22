package org.sample.compras.consumer.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 19/07/16.
 */
@Component
public class Constants {

    @Value("${spring.activemq.broker-url}")
    private String activeMQBrokerUrl;

    @Value("${queue.name}")
    private String queueName;

    public String getActiveMQBrokerUrl() {
        return activeMQBrokerUrl;
    }

    public String getQueueName() {
        return queueName;
    }
}
