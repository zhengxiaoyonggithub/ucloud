package com.ucloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;


@SpringBootApplication
@EnableDiscoveryClient
public class BusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusApplication.class,args);

    }
}
