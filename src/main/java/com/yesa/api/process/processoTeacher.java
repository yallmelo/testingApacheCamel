/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yesa.api.process;

import com.yesa.api.MyBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


/**
 *
 * @author yallisonmelo
 */
@Component
public class processoTeacher implements Processor{

    public void process(Exchange exchange) throws Exception {
        MyBean objeto =  exchange.getIn().getBody(MyBean.class);
        System.out.println("Professor: "+objeto.getName());
    }

   
}
