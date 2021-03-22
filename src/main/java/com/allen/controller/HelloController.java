package com.allen.controller;

import com.allen.entity.User;
import com.allen.mapper.UserMapper;
import com.allen.service.UserOperation;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class HelloController {
    private final UserMapper userMapper;
    private final UserOperation operation;

    @Autowired
    public HelloController(UserMapper userMapper, UserOperation operation) {
        this.userMapper = userMapper;
        this.operation = operation;
    }

    @GetMapping(value = "sayHello")
    public String sayHello(HttpServletResponse response) throws IOException {
        Cookie cookie=new Cookie("name","lintao");
        /*cookie.setDomain("localhost");
        cookie.setPath("/");*/
        response.addCookie(cookie);
        response.sendRedirect("http://localhost:9001/index/sayGoodbye");

        System.out.print("重定向");
        return "Hello Allen!";
    }
    @GetMapping(value = "sayGoodbye")
    public String sayGoodbye(HttpServletResponse response){
        return "Bye Allen!";
    }


    @GetMapping("/getUserData")
    public String getUserData(){
        List<User> users = userMapper.selectUserData();
        if (users!=null&&users.size()>0){
            /*return users.get(0).getName();*/
            return null;
        }
        return "为空";
    }

    @PostMapping("/register")
    public User userRegister(@RequestParam("user_name") String userName, @RequestParam("pass_word") String passWord){
        return operation.registerUser(userName,passWord);
    }
}
