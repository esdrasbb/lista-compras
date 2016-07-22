package org.sample.compras.producer.service;

import org.sample.compras.commons.model.Item;

/**
 * Created by esdrasbb on 13/07/16.
 */
public interface JmsService {

    void adicionaItem(Item item);

}
