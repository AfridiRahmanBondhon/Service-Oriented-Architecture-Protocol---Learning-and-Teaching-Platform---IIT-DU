package com.wsstudent.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    // Configure the message dispatcher servlet
    @Bean
    public MessageDispatcherServlet messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        return servlet;
    }

    // Register the servlet and map it to /ws/*
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(messageDispatcherServlet(), "/ws/*");
    }

    @Bean(name = "studentService")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/StudentService.wsdl"));
        return wsdl11Definition;
    }
}








