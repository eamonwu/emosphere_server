package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author eamon
* @description 针对表【post】的数据库操作Service
* @createDate 2023-11-09 17:55:10
*/
public interface PostService extends IService<Post> {
    //每页数量 以及页数
    List<Post> getRecentPosts(Integer currentPage, Integer pageSize);
    List<Post> getPostsByUserId(Integer currentPage, Integer pageSize, Integer uid);
    Post getPostById(Integer id);

    Integer addPost(Post post);
    Integer deletePostById(Integer id);
}
