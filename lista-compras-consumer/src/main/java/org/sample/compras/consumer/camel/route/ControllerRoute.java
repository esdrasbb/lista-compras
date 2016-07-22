package org.sample.compras.consumer.camel.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.sample.compras.consumer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

/**
 * Created by esdrasbb on 08/07/16.
 */
@Component
public class ControllerRoute extends RouteBuilder {

    @Autowired
    private Constants constants;

    @Autowired
    private CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.addComponent("activemq", activeMQComponent(constants.getActiveMQBrokerUrl()));

        from("activemq:queue:" + constants.getQueueName())
                .log("Received message [${body}]")
                .end();
    }
}
