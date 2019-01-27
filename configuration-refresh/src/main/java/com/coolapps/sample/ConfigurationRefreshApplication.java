package com.coolapps.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationRefreshApplication.class, args);
	}

}

