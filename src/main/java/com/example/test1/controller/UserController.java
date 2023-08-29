package com.example.test1.controller;

import com.example.test1.entity.User;
import com.example.test1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    UserService userService;

    //添加员工
    @RequestMapping("/update")
    public Integer update(User user) {
        return userService.changeUserById(user);
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userService.listAll();
    }

}
