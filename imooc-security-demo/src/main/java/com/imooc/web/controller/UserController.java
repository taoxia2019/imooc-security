package com.imooc.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.imooc.DTO.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/6/21 15:20
 * @Version 1.0
 */
@RestController
public class UserController {
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<User> query(@RequestParam(name="username") String nickname,@PageableDefault(page = 2,size = 10,sort = "username,asc") Pageable pageable){
        System.out.println(nickname);
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users=new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping(value="/user/{id}")
    public User getInfo(@PathVariable String id){
        User user=new User();
        user.setUsername("tom");
        return user;
    }
}
