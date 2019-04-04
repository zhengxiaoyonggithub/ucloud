package com.ucloud.basic.service.controller;


import com.ucloud.basic.service.mq.SendService;
import com.ucloud.basic.service.pojo.SystemUser;
import com.ucloud.basic.service.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;


    @Autowired
    private SendService sendService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public SystemUser login(String username, String password, String vcode) {
        SystemUser systemUser = new SystemUser();


        SystemUser user = systemUserService.findUserByUsername("zhengxiaoyong");

        System.out.println(user);

        systemUser.setId(1);
        systemUser.setUsername(username);
        systemUser.setPassword(password);
        systemUser.setCreateTime(new Date());
        systemUser.setUpdateTime(new Date());

        return systemUser;
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        if(url.indexOf("9999") == -1){
            try {
                Thread.sleep(2000);
            }catch (Exception ex){
                System.out.println("ex");
            }
        }
        System.out.println("hahaha");
        return url;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendRequest(){

        //创建消息
        Message message = MessageBuilder.withPayload("hello".getBytes()).build();
        //发送消息
        sendService.sendOrder().send(message);

        return "success";
    }

}
