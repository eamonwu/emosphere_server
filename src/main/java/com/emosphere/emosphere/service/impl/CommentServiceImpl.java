package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Comment;
import com.emosphere.emosphere.domain.Reply;
import com.emosphere.emosphere.mapper.ReplyMapper;
import com.emosphere.emosphere.service.CommentService;
import com.emosphere.emosphere.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author eamon
 * @description 针对表【comment】的数据库操作Service实现
 * @createDate 2023-11-10 19:46:32
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Comment> getCommentsByPostId(Integer postId, Integer pageSize, Integer currentPage) {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<Comment>().eq("post_id", postId);
        Page<Comment> page = new Page<>(currentPage, pageSize);
        List<Comment> comments = commentMapper.selectPage(page, commentQueryWrapper).getRecords();
        for (Comment comment : comments) {
            QueryWrapper<Reply> replyQueryWrapper = new QueryWrapper<Reply>().eq("comment_id", comment.getId());
            comment.setReplies(replyMapper.selectList(replyQueryWrapper));
        }
        return comments;
    }

    @Override
    public Integer addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.insert(comment);
    }

    @Override
    public Integer deleteCommentById(Integer id) {
        return commentMapper.deleteById(id);
    }
}




