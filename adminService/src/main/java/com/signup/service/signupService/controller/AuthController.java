package com.signup.service.signupService.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("authentication-service/auth")
public interface AuthController {

    @GetMapping("/get-token/{id}")
    String createToken(@PathVariable("id") int id);

}