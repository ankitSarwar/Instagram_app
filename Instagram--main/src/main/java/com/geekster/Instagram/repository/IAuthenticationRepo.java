package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.AuthenticationToken;
import com.geekster.Instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends CrudRepository<AuthenticationToken, Long> {


    AuthenticationToken findByUser(User user);


    AuthenticationToken findFirstByToken(String token);
}
