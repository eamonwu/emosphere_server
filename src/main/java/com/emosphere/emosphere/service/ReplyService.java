package com.emosphere.emosphere.service;

import com.emosphere.emosphere.domain.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author eamon
* @description 针对表【reply】的数据库操作Service
* @createDate 2023-11-10 19:46:32
*/
public interface ReplyService extends IService<Reply> {


    //获取回复就不分页了，太麻烦了
    List<Reply> getRepliesByCommentId(Integer commentId);

    Integer addReply(Reply reply);

    Integer deleteReplyById(Integer id);

}
