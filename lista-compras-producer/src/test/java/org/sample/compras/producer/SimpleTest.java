package org.sample.compras.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.compras.producer.bin.Producer;
import org.sample.compras.commons.model.Item;
import org.sample.compras.producer.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Producer.class)
public class SimpleTest{

    @Autowired
    private JmsService jmsService;

    @Test
    public void sendItem(){
        jmsService.adicionaItem(new Item(1L, 1));
    }

}