/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yesa.api.routes;

import com.yesa.api.predicate.validador;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yallisonmelo
 */
@Component
public class Despachante extends RouteBuilder {

    @Autowired
    validador validador;
    
    
    @Override
    public void configure() throws Exception {
        from("direct:dispachante")
                .choice()
                .when(validador).to("direct:student")
                .otherwise()
                .to("direct:teacher")
                .end();
    }

}
