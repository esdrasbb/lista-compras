/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sample.compras.producer.controller;

import org.sample.compras.producer.model.Item;
import org.sample.compras.producer.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private JmsService jmsService;

    @RequestMapping("/")
    @ResponseBody
    public String sayHi() {
        return "is alive!";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addItem(@RequestParam(value = "id", required = true) final Long id,
                          @RequestParam(value = "name", required = true) final String name,
                          @RequestParam(value = "quantidade", required = true) final Integer quantidade) {
        jmsService.adicionaItem(new Item(id, name, quantidade));
        return "OK";
    }

}
