package com.ykomarnytskyi.octofetch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OctoFetchApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctoFetchApplication.class, args);
	}

}
