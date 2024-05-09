package org.bakeli.bakeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication
public class BakeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakeliApplication.class, args);
	}

}
