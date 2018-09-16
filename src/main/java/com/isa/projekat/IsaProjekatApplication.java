package com.isa.projekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@EnableAsync
//@ComponentScan(basePackages = { "com.isa.projekat" })
public class IsaProjekatApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaProjekatApplication.class, args);
	}
}
