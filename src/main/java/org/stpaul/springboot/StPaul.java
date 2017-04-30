package org.stpaul.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import org.stpaul.springboot.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"org.stpaul.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class StPaul {

	public static void main(String[] args) {
		SpringApplication.run(StPaul.class, args);
	}
}
