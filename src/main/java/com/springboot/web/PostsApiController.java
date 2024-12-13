package com.springboot.web;

import com.springboot.dto.PostsDeleteRequestDto;
import com.springboot.dto.PostsResponseDto;
import com.springboot.dto.PostsSaveRequestDto;
import com.springboot.dto.PostsUpdateRequestDto;
import com.springboot.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id, @RequestBody PostsDeleteRequestDto requestDto) {
        postsService.delete(id, requestDto);
        return id;
    }




}
