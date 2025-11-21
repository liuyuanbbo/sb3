package io.jcz.microcloud.netflix.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MockSrvApp {
    public static void main(String[] args) {
        SpringApplication.run(MockSrvApp.class, args);
    }
}
