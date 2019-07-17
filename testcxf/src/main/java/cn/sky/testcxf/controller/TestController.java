package cn.sky.testcxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mytest")
public class TestController {
	
	//http://localhost:8080/skypoj/mytest/test1
	@RequestMapping("/test1")
	public Object test1() {
		return "test1";
	}

}
