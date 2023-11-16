package com.emosphere.emosphere.controller;

import com.emosphere.emosphere.domain.User;
import com.emosphere.emosphere.domain.UserLoginParam;
import com.emosphere.emosphere.service.UserService;
import com.emosphere.emosphere.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    R login(@Validated @RequestBody UserLoginParam userLoginParam) {
        return R.ok("登陆成功").put("user", userService.login(userLoginParam));
    }

    @PostMapping("/update")
    R updateUserInfo(@RequestBody User user) {
        return R.ok("更新成功").put("user", userService.updateUserInfo(user));
    }
}
