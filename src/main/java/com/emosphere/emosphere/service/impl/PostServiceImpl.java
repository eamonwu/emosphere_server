package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Post;
import com.emosphere.emosphere.service.PostService;
import com.emosphere.emosphere.mapper.PostMapper;
import com.emosphere.emosphere.utils.BizErrorCodeEnum;
import com.emosphere.emosphere.utils.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author eamon
 * @description 针对表【post】的数据库操作Service实现
 * @createDate 2023-11-09 17:55:10
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public List<Post> getRecentPosts(Integer currentPage, Integer pageSize) {
        Page<Post> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Post> wrapper = new QueryWrapper<Post>().orderByDesc("create_date");
        IPage<Post> posts = postMapper.selectPage(page, wrapper);
        return posts.getRecords();
    }

    @Override
    public List<Post> getPostsByUserId(Integer currentPage, Integer pageSize, Integer uid) {
        Page<Post> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Post> wrapper = new QueryWrapper<Post>()
                .eq("uid", uid)
                .orderByDesc("create_date");
        IPage<Post> posts = postMapper.selectPage(page, wrapper);
        return posts.getRecords();
    }

    @Override
    public Post getPostById(Integer id) {
        Post post = postMapper.selectById(id);
        if (post == null) {
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
        post.setBrowseCount(post.getBrowseCount() + 1);
        postMapper.updateById(post);
        return post;
    }

    @Override
    public Integer addPost(Post post) {
        post.setId(null);
        post.setCategoryId(null);
        post.setStatus(0);
        post.setBrowseCount(0);
        post.setCommentCount(0);
        post.setLikeCount(0);
        post.setCreateDate(new Date());
        post.setUpdateDate(new Date());
        return postMapper.insert(post);
    }

    @Override
    public Integer deletePostById(Integer id) {

        int result = postMapper.deleteById(id);
        if(result ==0){
            throw new BizException(BizErrorCodeEnum.MOOD_RECORD_DOESNT_EXIST);
        }
        return  result;
    }
}




