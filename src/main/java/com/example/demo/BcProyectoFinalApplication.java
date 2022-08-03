package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableConfigServer
@EnableReactiveMongoAuditing
public class BcProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcProyectoFinalApplication.class, args);
	}

}
