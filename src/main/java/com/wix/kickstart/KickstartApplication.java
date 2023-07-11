package com.wix.kickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickstartApplication.class, args);
	}

}
