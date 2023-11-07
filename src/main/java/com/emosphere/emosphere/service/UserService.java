package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emosphere.emosphere.domain.UserLoginParam;

/**
* @author eamon
* @description 针对表【user】的数据库操作Service
* @createDate 2023-11-07 18:21:58
*/
public interface UserService extends IService<User> {
    User login(UserLoginParam userLoginParam);
}
