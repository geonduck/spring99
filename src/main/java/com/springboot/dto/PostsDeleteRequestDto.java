package com.springboot.dto;

import com.springboot.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsDeleteRequestDto {

    private String pw;

    public Posts toEntity() {
        return Posts.builder()
                .pw(pw)
                .build();
    }
}
