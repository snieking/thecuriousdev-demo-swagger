package org.thecuriousdev.demo.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.thecuriousdev.demo.skeleton.config.SwaggerConfig;

@SpringBootApplication
@ComponentScan
public class MockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}
}
