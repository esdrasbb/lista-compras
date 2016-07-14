package org.sample.compras.producer.service.impl;

import org.sample.compras.producer.model.Item;
import org.sample.compras.producer.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by esdrasbb on 13/07/16.
 */
@Service
public class JmsServiceImpl implements JmsService {

    @Value("${queue.name}")
    private String QUEUE;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void adicionaItem(Item item) {
        jmsTemplate.convertAndSend(QUEUE, item);
    }
}
