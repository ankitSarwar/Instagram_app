package com.geekster.Instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    private String postData;
    //(use any dummy string here ex "abcd" . this will be replaced by image link string in class)


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
