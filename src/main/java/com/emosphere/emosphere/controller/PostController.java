package com.emosphere.emosphere.controller;


import com.emosphere.emosphere.domain.Post;
import com.emosphere.emosphere.service.PostService;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/recent")
    R getRecentPosts(@RequestParam("pageSize") Integer pageSize,
                     @RequestParam("currentPage") Integer currentPage) {
        List<Post> posts = postService.getRecentPosts(currentPage, pageSize);
        return R.ok("查询成功").put("posts", posts);
    }

    @GetMapping("/uid")
    R getPostsByUserId(
            @RequestParam("uid") Integer uid,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("currentPage") Integer currentPage) {
        List<Post> posts = postService.getPostsByUserId( currentPage, pageSize,uid);
        return R.ok("查询成功").put("posts", posts);
    }

    @GetMapping("/id")
    R getPostById(@RequestParam("id") Integer id) {
        Post post = postService.getPostById(id);
        return R.ok("查询成功").put("post", post);
    }

    @PostMapping("")
    R addPost(@Validated @RequestBody Post post) {
        postService.addPost(post);
        return R.ok("添加成功");
    }

    @DeleteMapping("")
    R deletePost(@RequestParam("id") Integer id) {
        postService.deletePostById(id);
        return R.ok("删除成功");
    }
}
