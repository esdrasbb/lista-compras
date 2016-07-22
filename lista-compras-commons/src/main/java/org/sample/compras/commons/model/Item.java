package org.sample.compras.commons.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by esdrasbb on 08/07/16.
 */
public class Item implements Serializable {

    private Long id;
    private Integer amount;

    public Item(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
