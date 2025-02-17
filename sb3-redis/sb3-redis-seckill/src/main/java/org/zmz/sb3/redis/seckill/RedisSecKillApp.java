package org.zmz.sb3.redis.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisSecKillApp {
    public static void main(String[] args) {
        SpringApplication.run(RedisSecKillApp.class, args);
    }
}
