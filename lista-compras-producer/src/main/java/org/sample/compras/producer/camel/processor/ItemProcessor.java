package org.sample.compras.producer.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.Validate;
import org.sample.compras.commons.model.Item;
import org.sample.compras.producer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 19/07/16.
 */
@Component
public class ItemProcessor implements Processor {

    @Autowired
    private Constants constants;

    @Override
    public void process(Exchange exchange) throws Exception {
        String id = exchange.getIn().getHeader(constants.getItemNameId(), String.class);
        String amount = exchange.getIn().getHeader(constants.getItemNameAmount(), String.class);

        validate(id, amount);

        exchange.getIn().setBody(new Item(Long.valueOf(id), Integer.valueOf(amount)));
    }

    private void validate(String id, String amount) {
        Validate.notNull(id);
        Validate.notNull(amount);
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, Long.valueOf(id).longValue());
        Validate.inclusiveBetween(1, Integer.MAX_VALUE, Integer.valueOf(id).intValue());
    }
}
