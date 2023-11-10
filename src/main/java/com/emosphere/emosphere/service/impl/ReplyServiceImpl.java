package com.emosphere.emosphere.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emosphere.emosphere.domain.Reply;
import com.emosphere.emosphere.service.ReplyService;
import com.emosphere.emosphere.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author eamon
 * @description 针对表【reply】的数据库操作Service实现
 * @createDate 2023-11-10 19:46:32
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
        implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Reply> getRepliesByCommentId(Integer commentId) {
        return replyMapper.selectList(new QueryWrapper<Reply>().eq("comment_id", commentId));
    }

    @Override
    public Integer addReply(Reply reply) {
        reply.setCreateTime(new Date());
        return replyMapper.insert(reply);
    }

    @Override
    public Integer deleteReplyById(Integer id) {
        return replyMapper.deleteById(id);
    }
}




