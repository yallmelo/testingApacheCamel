/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yesa.api.routes;

import com.yesa.api.process.processo;
import com.yesa.api.process.processoTeacher;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yallisonmelo
 */
@Component
public class Teacher extends RouteBuilder {

    @Autowired
    processoTeacher prc;

    @Override
    public void configure() throws Exception {

        from("direct:teacher")
                .routeId("routeteacher")
                .process(prc)
                .endRest();
    }

}
