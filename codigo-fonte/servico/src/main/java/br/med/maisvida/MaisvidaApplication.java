package br.med.maisvida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class MaisvidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaisvidaApplication.class, args);
	}
}
