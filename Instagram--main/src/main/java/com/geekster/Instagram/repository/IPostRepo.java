package com.geekster.Instagram.repository;

import com.geekster.Instagram.model.AuthenticationToken;
import com.geekster.Instagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepo extends CrudRepository<Post, Integer> {



}
