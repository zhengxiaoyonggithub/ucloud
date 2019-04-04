package com.ucloud.basic.service.service.impl;

import com.netflix.discovery.converters.Auto;
import com.ucloud.basic.service.dao.SystemUserMapper;
import com.ucloud.basic.service.pojo.SystemUser;
import com.ucloud.basic.service.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;


    @Override
    public SystemUser findUserByUsername(String username) {
        return systemUserMapper.findUserByUsername(username);
    }
}
