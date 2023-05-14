package com.geekster.Instagram.service;

import com.geekster.Instagram.model.AuthenticationToken;
import com.geekster.Instagram.model.User;
import com.geekster.Instagram.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authRepo;
    public void saveToken(AuthenticationToken token)
    {
        authRepo.save(token);
    }


    public AuthenticationToken getToken(User user)
    {
        return  authRepo.findByUser(user);
    }

    public boolean authenticate(String email, String token)
    {

        AuthenticationToken authToken = authRepo.findFirstByToken(token);
        //find token object via token string
        String expectedEmail = authToken.getUser().getEmail();
        return expectedEmail.equals(email);

    }
}
