package org.sample.compras.producer.camel.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.sample.compras.producer.camel.processor.ItemProcessor;
import org.sample.compras.producer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

/**
 * Created by esdrasbb on 08/07/16.
 */
@Component
public class ControllerRoute extends RouteBuilder {

    @Autowired
    private ItemProcessor itemProcessor;

    @Autowired
    private Constants constants;

    @Autowired
    private CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.addComponent("activemq", activeMQComponent(constants.getActiveMQBrokerUrl()));

        restConfiguration().component("jetty").port(constants.getPort())
                .bindingMode(RestBindingMode.auto);

        rest("/")
                .get("ping").produces("text/html").route().transform().constant("is alive").log("Received ping [${body}]").endRest()
                .get("/add/{id}/{amount}").produces("text/html").to("direct:add");

        from("direct:add")
                .process(itemProcessor)
                .log("Received message [${body}]")
                .inOnly("activemq:queue:" + constants.getQueueName())
                .transform().constant("item added").end();
    }
}
