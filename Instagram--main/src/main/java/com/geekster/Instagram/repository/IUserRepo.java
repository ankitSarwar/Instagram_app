package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.Post;
import com.geekster.Instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {

    User findFirstByEmail(String email);


}
