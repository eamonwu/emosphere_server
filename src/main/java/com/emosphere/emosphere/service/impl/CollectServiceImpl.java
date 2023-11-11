package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Collect;
import com.emosphere.emosphere.service.CollectService;
import com.emosphere.emosphere.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author eamon
 * @description 针对表【collect】的数据库操作Service实现
 * @createDate 2023-11-11 20:32:50
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect>
        implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> getCollectsByUid(Integer uid, Integer pageSize, Integer currentPage) {
        Page<Collect> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Collect> wrapper = new QueryWrapper<Collect>()
                .eq("uid", uid);
        return collectMapper.selectPage(page, wrapper).getRecords();
    }

    @Override
    public Integer addCollect(Collect collect) {
        return collectMapper.insert(collect);

    }

    @Override
    public Integer deleteCollect(Integer id) {
        return collectMapper.deleteById(id);
    }
}




