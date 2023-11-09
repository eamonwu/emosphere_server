package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Log;
import com.emosphere.emosphere.service.LogService;
import com.emosphere.emosphere.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
* @author eamon
* @description 针对表【log】的数据库操作Service实现
* @createDate 2023-11-09 20:56:35
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}




