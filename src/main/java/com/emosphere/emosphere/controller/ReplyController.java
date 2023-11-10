package com.emosphere.emosphere.controller;

import com.emosphere.emosphere.domain.Comment;
import com.emosphere.emosphere.domain.Reply;
import com.emosphere.emosphere.service.CommentService;
import com.emosphere.emosphere.service.ReplyService;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reply" )
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("")
    R addComment(@RequestBody Reply reply){
        replyService.addReply(reply);
        return R.ok("添加成功");
    }

    @DeleteMapping("")
    R deleteReplyById(@RequestParam("id") Integer id){
        replyService.deleteReplyById(id);
        return R.ok("删除成功");
    }
}
