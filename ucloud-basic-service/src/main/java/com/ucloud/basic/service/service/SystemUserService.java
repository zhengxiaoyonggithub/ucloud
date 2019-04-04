package com.ucloud.basic.service.service;

import com.ucloud.basic.service.pojo.SystemUser;

public interface SystemUserService {

    SystemUser findUserByUsername(String username);

}
