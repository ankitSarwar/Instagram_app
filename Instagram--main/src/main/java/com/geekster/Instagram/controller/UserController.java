package com.geekster.Instagram.controller;

import com.geekster.Instagram.dto.SignInInput;
import com.geekster.Instagram.dto.SignInOutput;
import com.geekster.Instagram.dto.SignUpInput;
import com.geekster.Instagram.dto.SignUpOutput;
import com.geekster.Instagram.model.User;
import com.geekster.Instagram.service.AuthenticationService;
import com.geekster.Instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authService;

    @PostMapping("/add/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto)
    {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/add/signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto)
    {
        return userService.signIn(signInDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestParam String email,@RequestParam String token,@RequestBody SignUpInput signUpInput){
        HttpStatus status;
        String message = "";
        if(authService.authenticate(email,token)){
            userService.updateUser(signUpInput);
            message = "Updated Successfully";
            status = HttpStatus.ACCEPTED;
        }else{
            message ="Invalid Details to update the user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(message,status);

    }
}
