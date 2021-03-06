package com.bankingapplicationmain.bankingapplicationmain;

import com.bankingapplicationmain.bankingapplicationmain.models.enums.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class BankingApplicationMain {

	private static final Logger logger = LoggerFactory.getLogger(BankingApplicationMain.class);


	public static void main(String[] args) {
		SpringApplication.run(BankingApplicationMain.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> logger.info("Running application!");
	}



}


