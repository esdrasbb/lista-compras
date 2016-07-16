package org.sample.compras.producer.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 08/07/16.
 */
@Component
public class ControllerRoute extends RouteBuilder {

    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String host;


    @Override
    public void configure() throws Exception {
        restConfiguration().component("jetty").port(port)
                .bindingMode(RestBindingMode.auto);

        rest("/")
                .get("ping").produces("text/html").route().transform().constant("is alive").log("Received ping [${body}]").endRest()
                .get("/add").produces("text/html").to("direct:add");

        from("direct:add")
                .transform().constant("Hello World").log("Received message [${body}]");

//        from("timer:hello?period={{timer.period}}")
//                .transform(method("item", "saySomething"))
//                .log("Received message [${body}]");;
    }
}
