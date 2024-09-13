package br.com.fiap.WellDone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan
@EntityScan
@SpringBootApplication
public class WellDoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellDoneApplication.class, args);
	}

}
