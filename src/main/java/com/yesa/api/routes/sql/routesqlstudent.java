package com.yesa.api.routes.sql;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class routesqlstudent extends RouteBuilder {

    @Value("${sql.consultaEstudantes}")
    private String consulta;
    
    @Override
    public void configure() throws Exception {
        from("direct:students")
                .to("sql:".concat(consulta));
    }

}
