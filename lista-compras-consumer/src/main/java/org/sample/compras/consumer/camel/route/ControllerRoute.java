package org.sample.compras.consumer.camel.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.sample.compras.consumer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

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
        camelContext.addComponent("sql", new SqlComponent(camelContext));

        from("activemq:queue:" + constants.getQueueName())
                .log("Received message [${body}]")
                .to("sql:insert into item (id, amount) values (:#id, :#amount)?dataSourceRef=dataSource")
                .to("sql:select * from item?dataSourceRef=dataSource")
                .process(new Processor() {

                    public void process(Exchange exchange)
                            throws Exception {
                        System.out.println(exchange.getIn()
                                .getBody().getClass());
                        System.out.println(exchange.getIn()
                                .getBody());
                    }
                })
                .end();
    }
}
