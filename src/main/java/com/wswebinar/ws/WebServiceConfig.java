package com.wswebinar.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.core.io.ClassPathResource;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

//    @Bean(name = "webinar")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema webinarSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("WebinarPort");
//        wsdl11Definition.setLocationUri("/ws");
//        wsdl11Definition.setTargetNamespace("http://www.wswebinar.com/ws/webinar");
//        wsdl11Definition.setSchema(webinarSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema webinarSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("/xsd/WebinarService.xsd"));
//    }

    @Bean(name = "webinar")
    public Wsdl11Definition quizServiceWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/QuizService.wsdl"));
        return wsdl11Definition;
    }
}
