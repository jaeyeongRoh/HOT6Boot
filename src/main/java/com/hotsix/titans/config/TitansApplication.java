package com.hotsix.titans.config;

import com.hotsix.titans.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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