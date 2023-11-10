package com.emosphere.emosphere.controller;


import com.emosphere.emosphere.domain.Comment;
import com.emosphere.emosphere.service.CommentService;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/post_id")
    R getCommentsByPostId(
            @RequestParam("postId") Integer postId,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("currentPage") Integer currentPage) {
        List<Comment> comments = commentService.getCommentsByPostId(postId, pageSize, currentPage);
        return R.ok("查询成功").put("comments", comments);
    }

    @PostMapping("")
    R addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return R.ok("添加成功");
    }

    @DeleteMapping("")
    R deleteCommentById(@RequestParam("id") Integer id){
        commentService.deleteCommentById(id);
        return R.ok("删除成功");
    }
}
