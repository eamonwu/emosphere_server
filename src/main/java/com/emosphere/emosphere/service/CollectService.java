package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author eamon
* @description 针对表【collect】的数据库操作Service
* @createDate 2023-11-11 20:32:50
*/
public interface CollectService extends IService<Collect> {

    List<Collect> getCollectsByUid(Integer uid,Integer pageSize,Integer currentPage);

    Integer addCollect(Collect collect);

    Integer deleteCollect(Integer id);

}
