package org.sid.discoverysc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryScApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryScApplication.class, args);
	}

}
