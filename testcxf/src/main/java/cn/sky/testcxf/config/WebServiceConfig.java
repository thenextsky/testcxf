package cn.sky.testcxf.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.sky.testcxf.serviceout.UserService;

@Configuration
public class WebServiceConfig{
	
	@Autowired
	Bus bus;
	
	@Autowired
	@Qualifier("userService111")
	UserService us1;
	
	@Autowired
	@Qualifier("userService222")
	UserService us2;
	
	/**
	 * 这里相当于把UserService接口发布在了路径/services/UserService_publish1下,
	 * wsdl文档路径为http://localhost:8080/services/UserService_publish1?wsdl
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus,us1);
		endpoint.publish("/UserService_publish1");
		return endpoint;
	}
	
	/**
	 * 这里相当于把UserService接口发布在了路径/services/UserService_publish2下,
	 * wsdl文档路径为http://localhost:8080/services/UserService_publish2?wsdl
	 */
	@Bean
	public Endpoint endpoint2() {
		EndpointImpl endpoint = new EndpointImpl(bus,us2);
		endpoint.publish("/UserService_publish2");
		return endpoint;
	}
	
}