package com.hotsix.titans.config;

import com.hotsix.titans.attendanceManagement.service.LeaveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotsix.titans")
public class TitansApplication {

    private static LeaveService leaveService;

    public TitansApplication(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TitansApplication.class, args);

        leaveService.listAll();
    }

}
