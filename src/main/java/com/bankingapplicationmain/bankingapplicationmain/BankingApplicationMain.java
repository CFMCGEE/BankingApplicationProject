package com.bankingapplicationmain.bankingapplicationmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankingApplicationMain {

<<<<<<< HEAD
// test run 123
=======
	private static final Logger logger = LoggerFactory.getLogger(BankingApplicationMain.class);

>>>>>>> d4760a4408bcd2524fc776f6ff8622fd30eeaa3a
	public static void main(String[] args) {
		System.out.println("Hello Bank");
		SpringApplication.run(BankingApplicationMain.class, args);
	}

<<<<<<< HEAD
}
=======
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> logger.info("Running application!");
	}

}
>>>>>>> d4760a4408bcd2524fc776f6ff8622fd30eeaa3a
