package com.ucloud.sale.service;


import com.ucloud.sale.service.mq.ReceiveService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@ServletComponentScan
@EnableBinding(ReceiveService.class)
@MapperScan("com.ucloud.sale.service.dao")
public class SaleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaleServiceApplication.class, args);

//        BeanFactory
        //FactoryBean
        //ApplicationContext
    }

    @StreamListener("myInput")
    public void receive(byte[] msg) {
        System.out.println("接收到的消息：" + new String(msg));
    }
}
