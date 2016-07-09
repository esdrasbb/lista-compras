package org.sample.compras.producer.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by esdrasbb on 08/07/16.
 */
@Component
public class Item {

    @Value("${greeting}")
    private String say;

    public String saySomething() {
        return say;
    }

}
