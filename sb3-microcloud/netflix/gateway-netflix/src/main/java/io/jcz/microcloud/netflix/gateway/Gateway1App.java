package io.jcz.microcloud.netflix.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway1App {
    public static void main(String[] args) {
        SpringApplication.run(Gateway1App.class, args);
    }
}
