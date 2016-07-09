package org.sample.compras.producer.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 08/07/16.
 */
@Component
public class MQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}")
                .transform(method("item", "saySomething"))
                .to("stream:out");
    }
}
