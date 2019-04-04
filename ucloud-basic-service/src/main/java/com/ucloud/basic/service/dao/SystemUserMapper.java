package com.ucloud.basic.service.dao;

import com.ucloud.basic.service.pojo.SystemUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserMapper {

    SystemUser findUserByUsername(String username);
}
