package org.sample.compras.producer.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by esdrasbb on 08/07/16.
 */
public class Item implements Serializable {

    private Long id;
    private String nome;
    private Integer quantidade;

    public Item(Long id, String nome, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
