package com.consumer.BusServiceConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BusServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusServiceConsumerApplication.class, args);
	}

}
