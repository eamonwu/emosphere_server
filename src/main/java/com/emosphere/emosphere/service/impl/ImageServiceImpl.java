package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Image;
import com.emosphere.emosphere.service.ImageService;
import com.emosphere.emosphere.mapper.ImageMapper;
import org.springframework.stereotype.Service;

/**
* @author eamon
* @description 针对表【image】的数据库操作Service实现
* @createDate 2023-11-08 18:34:10
*/
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image>
    implements ImageService{

}




