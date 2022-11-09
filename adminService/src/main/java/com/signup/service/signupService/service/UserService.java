package com.signup.service.signupService.service;

import com.signup.service.signupService.controller.AuthController;
import com.signup.service.signupService.model.User;
import com.signup.service.signupService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthController authController;

    public String signupService(User user){

        User savedUser = userRepository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created User\",\n"+
                "\"data\":"+savedUser+",\n"+
                "}";
    }

    public String loginService(String email, String password){
        List<User> foundUsers =  userRepository.loginUser(email);

        if(foundUsers.isEmpty()){
            return "{\n" +
                    "\"message\":"+"\" User not found !\",\n"+
                    "}";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "{\n" +
                    "\"message\":"+"\" Incorrect Password !\",\n"+
                    "}";
        }

        return "{\n" +
                "\"message\":"+"\" Login successful\",\n"+
                "\"data\": {\n"+"       Name : "+foundUsers.get(0).getName()+",\n"+
                                "       id : "+foundUsers.get(0).getId()+",\n"+
                                "       Email : "+foundUsers.get(0).getEmail()+"\n"+
                                "       Token : "+ authController.createToken(foundUsers.get(0).getId())+"\n"+
                            "   }\n"+
                "}";

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
