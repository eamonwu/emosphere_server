package com.emosphere.emosphere.mapper;

import com.emosphere.emosphere.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author eamon
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-07 18:21:58
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




