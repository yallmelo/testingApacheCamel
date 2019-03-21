/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yesa.api.predicate;

import com.yesa.api.MyBean;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;

/**
 *
 * @author yallisonmelo
 */
@Component
public class validador implements Predicate {
    
    public boolean matches(Exchange exchange) {
        MyBean objeto = exchange.getIn().getBody(MyBean.class);
        return  objeto.getName().equals("felipe");
    }
    
}
