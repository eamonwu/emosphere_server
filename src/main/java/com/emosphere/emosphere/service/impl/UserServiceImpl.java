package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.User;
import com.emosphere.emosphere.domain.UserLoginParam;
import com.emosphere.emosphere.service.UserService;
import com.emosphere.emosphere.mapper.UserMapper;
import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
* @author eamon
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-07 18:21:58
*/
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    private static final String AUTH_CODE="6666";

    @Autowired
    UserMapper userMapper;
    @Override
    public User login(UserLoginParam userLoginParam) {
        if(!AUTH_CODE.equals(userLoginParam.getAuthCode())){
            throw new BizException(BizErrorCodeEnum.UNAUTHORIZED);
        }
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("phone",userLoginParam.getPhone()));
        Date now = new Date();
        //如果用户没有登录过，自动注册用户并登录
        if(user==null){
            user = new User();
            user.setPhone(userLoginParam.getPhone());
            user.setUsername("手机用户"+userLoginParam.getPhone());
            user.setCreateDate(now);
            user.setStatus(0);
            user.setLastLoginDate(now);
            save(user);
        }else {
            user.setLastLoginDate(now);
            update(user,new QueryWrapper<User>().eq("id",user.getId()));
        }
        //敏感信息去除，目前还没有，先隐藏status
        user.setStatus(null);
        return user;
    }
}




