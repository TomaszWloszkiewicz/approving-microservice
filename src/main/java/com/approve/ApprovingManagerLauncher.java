package com.approve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@EnableAsync
public class ApprovingManagerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApprovingManagerLauncher.class);
    }
}
