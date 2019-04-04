package com.ucloud.sale.service.controller;

import com.ucloud.sale.service.feign.BasicFeignClient;
import com.ucloud.sale.service.pojo.SaleOrder;
import com.ucloud.sale.service.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@Configuration
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;


    @Autowired
    private BasicFeignClient basicFeignClient;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/saveOrder")
    public void saveOrder(SaleOrder order){

        if(order != null){
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
        }

        System.out.println(order);
        saleOrderService.saveOrder(order);
    }

    @RequestMapping(value = "router", method = RequestMethod.GET)
    public String router(){
        return basicFeignClient.router();
        //return getRestTemplate().getForObject("http://ucloud-basic-service/router",String.class);
    }

}
