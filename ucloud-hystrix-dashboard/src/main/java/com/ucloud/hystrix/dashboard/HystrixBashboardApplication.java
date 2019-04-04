package com.ucloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixBashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixBashboardApplication.class,args);
    }
}
