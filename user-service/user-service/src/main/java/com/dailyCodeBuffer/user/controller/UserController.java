package com.dailyCodeBuffer.user.controller;

import com.dailyCodeBuffer.user.VO.ResponseTemplateVO;
import com.dailyCodeBuffer.user.entity.User;
import com.dailyCodeBuffer.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser in controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id) {
        log.info("inside getUserWithDepartment in controller");
        return userService.getUserWithDepartment(id);
    }
}
