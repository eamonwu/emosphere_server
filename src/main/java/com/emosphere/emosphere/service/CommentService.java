package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author eamon
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-11-10 19:46:32
*/
public interface CommentService extends IService<Comment> {



    List<Comment> getCommentsByPostId(Integer postId,Integer pageSize,Integer currentPage);

    Integer addComment(Comment comment);

    Integer deleteCommentById(Integer id);

}
