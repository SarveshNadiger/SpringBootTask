package org.impelsys.PracticeBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PracticeBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeBootApplication.class, args);
	}

}
