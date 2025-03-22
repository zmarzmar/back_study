package com.backstudy.book.web;

import com.backstudy.book.service.posts.PostsService;
import com.backstudy.book.web.dto.PostsResponseDto;
import com.backstudy.book.web.dto.PostsSaveRequestDto;
import com.backstudy.book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService; // 서비스 클래스 객체 생성

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto); // 저장 요청 몇 번 게시글이 저장됐는지 확인
    }

    @PutMapping ("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);// 수정 완료된 게시글 번호를 다시 보내줌
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id); // PostsResponseDto로 가공된 데이터(제목, 내용 등)를 리턴
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id; // 몇번 게시글 삭제됨 이라고 확인 가능
    }

}
