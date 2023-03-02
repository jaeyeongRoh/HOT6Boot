package com.hotsix.titans.config;

import com.hotsix.titans.attendanceManagement.controller.LeaveController;
import com.hotsix.titans.attendanceManagement.service.LeaveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotsix.titans")
public class TitansApplication {

    private static LeaveService leaveService;

    private static LeaveController leaveController;

    public TitansApplication(LeaveService leaveService, LeaveController leaveController) {
        this.leaveService = leaveService;
        this.leaveController = leaveController;
    }

    public static void main(String[] args) {
        SpringApplication.run(TitansApplication.class, args);

        leaveService.listAll();

        leaveController.listAllPrint();
    }

}
