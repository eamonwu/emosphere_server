package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.User;
import com.emosphere.emosphere.service.UserService;
import com.emosphere.emosphere.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author eamon
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-07 18:21:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




