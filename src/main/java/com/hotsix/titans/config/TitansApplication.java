package com.hotsix.titans.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotsix.titans")
public class TitansApplication {

    public static void main(String[] args) {
        SpringApplication.run(TitansApplication.class, args);
    }

}