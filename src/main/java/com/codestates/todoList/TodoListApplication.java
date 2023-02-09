package com.codestates.todoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoListApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoListApplication.class);
	}

}
//아파치 톰캣을 이용해서 수동 배포를 하기 extends SpringBootServletInitializer 추가
//@Ovcerride 부분 추가

//build.gradle의 plugins {
//	id 'java'
//	id 'org.springframework.boot' version '2.7.8'
//	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
//	id 'war'
//}
// id 'war' 부분 추가됨