package com.yesa.api.routes;

import com.yesa.api.process.processo;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student extends RouteBuilder {

    @Autowired
    processo prc;

    @Override
    public void configure() throws Exception {        
        
        from("direct:student")
                .routeId("routestudent")
                .process(prc)
                .to("direct:students")
                .endRest();
    }

}
