package com.imooc.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.DTO.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
@RequestMapping("/user")
public class UserController {
    //测试拉取pull 上传push

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        System.out.println(id);
    }

    @PutMapping("/{id}")
    //@JsonView(User.UserDetailView.class)
    public User update(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                //FieldError fieldError= (FieldError) error;
                //String message=fieldError.getField() +" " +error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PostMapping
    //@JsonView(User.UserDetailView.class)
    public User create(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }


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
        throw new RuntimeException("user is not exist");
        /*User user=new User();
        user.setUsername("tom");*/
        //return user;
    }
}
