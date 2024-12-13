package com.springboot.dto;

import com.springboot.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;
    private String pw;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .pw(pw)
                .build();
    }

}
