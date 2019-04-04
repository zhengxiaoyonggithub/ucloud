package com.ucloud.sale.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ucloud-basic-service",fallback = BasicFeignClient.FallbackBasicFeignClient.class)
public interface BasicFeignClient {

    @RequestMapping(value = "/router",method = RequestMethod.GET)
    String router();

    @Component
    static class FallbackBasicFeignClient implements BasicFeignClient{
        @Override
        public String router() {
            return "我回退了";
        }
    }
}
