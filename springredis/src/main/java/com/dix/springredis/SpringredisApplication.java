package com.dix.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringredisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringredisApplication.class, args);
	}
}
