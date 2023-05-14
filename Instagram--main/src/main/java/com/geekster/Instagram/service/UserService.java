package com.geekster.Instagram.service;

import com.geekster.Instagram.dto.SignInInput;
import com.geekster.Instagram.dto.SignInOutput;
import com.geekster.Instagram.dto.SignUpInput;
import com.geekster.Instagram.dto.SignUpOutput;
import com.geekster.Instagram.model.AuthenticationToken;
import com.geekster.Instagram.model.User;
import com.geekster.Instagram.repository.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    AuthenticationService authService;

    public SignUpOutput signUp(SignUpInput signUpDto)
    {
        User user =userRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }

        //encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        user = new User(signUpDto.getFirstName(),
                signUpDto.getLastName(),signUpDto.getAge(),signUpDto.getEmail(),
                encryptedPassword, signUpDto.getContact());

        userRepo.save(user);

        AuthenticationToken token = new AuthenticationToken(user);

        authService.saveToken(token);

        return new SignUpOutput("User registered","User created successfully");
    }
    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        User user = userRepo.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authToken = authService.getToken(user);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());
    }
    public void updateUser(SignUpInput signUpInput) {
        User user1 = userRepo.findFirstByEmail(signUpInput.getEmail());
        if(user1 == null){
            throw new IllegalStateException("User invalid..!!!");
        }
        String encryptedPassword = null;
        if(signUpInput.getEmail() != null)
        {
            try {
                encryptedPassword = encryptPassword(signUpInput.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        //save the user
        User user = new User(signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getAge(),signUpInput.getEmail(),encryptedPassword,signUpInput.getContact());

        userRepo.save(user);
    }
}


