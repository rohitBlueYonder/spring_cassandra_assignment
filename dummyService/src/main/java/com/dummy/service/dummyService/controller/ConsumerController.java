package com.dummy.service.dummyService.controller;


import com.dummy.service.dummyService.model.User;
import com.netflix.discovery.converters.Auto;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    UserRestConsumer restConsumer;

    @GetMapping("/get-users")
    List<User> getUsers(){
        System.out.println(restConsumer.getClass().getSimpleName());
        System.out.println("accessing through admin-service");
        return restConsumer.getUsers();
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        return restConsumer.signup(user);
    }

    @PostMapping("/login")
    String login(@RequestBody Map<String, Object> map){
        return restConsumer.login(map);
    }
}
