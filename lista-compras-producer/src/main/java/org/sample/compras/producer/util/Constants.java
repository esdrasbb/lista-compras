package org.sample.compras.producer.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 19/07/16.
 */
@Component
public class Constants {

    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String host;

    @Value("${item.name.id}")
    private String itemNameId;

    @Value("${item.name.amount}")
    private String itemNameAmount;

    @Value("${spring.activemq.broker-url}")
    private String activeMQBrokerUrl;

    @Value("${queue.name}")
    private String queueName;

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getItemNameId() {
        return itemNameId;
    }

    public String getItemNameAmount() {
        return itemNameAmount;
    }

    public String getActiveMQBrokerUrl() {
        return activeMQBrokerUrl;
    }

    public String getQueueName() {
        return queueName;
    }
}
