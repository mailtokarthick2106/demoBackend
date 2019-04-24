package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Testing");
	}
}
	
	@RestController
	class MessageRestController {
	 
	    @RequestMapping("/hello")
	    String getMessage(@RequestParam(value = "name") String name) {
	        String rsp = "Hi " + name + " : responded on - " + new Date();
	        System.out.println(rsp);
	        return rsp;
	    }
}
