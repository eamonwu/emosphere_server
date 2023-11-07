package com.emosphere.emosphere.controller;

import com.emosphere.emosphere.domain.UserLoginParam;
import com.emosphere.emosphere.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    R login(@RequestBody UserLoginParam userLoginParam){
        return  R.ok("登陆成功");
    }

}
