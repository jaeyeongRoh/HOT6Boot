package com.hotsix.titans.config;

import com.hotsix.titans.salary.service.SalaryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hotsix.titans")
public class TitansApplication {

//    private static SalaryService salaryService;

//    public TitansApplication(SalaryService salaryService) {
//        this.salaryService = salaryService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(TitansApplication.class, args);

//        salaryService.selectMySalary(paymentDate);
    }

}
