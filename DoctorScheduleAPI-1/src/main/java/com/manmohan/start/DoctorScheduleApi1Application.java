package com.manmohan.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.manmohan.start")
public class DoctorScheduleApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(DoctorScheduleApi1Application.class, args);
		
		
		
	}

}
