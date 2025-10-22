package com.ljh.myform.controller;

import com.ljh.myform.dto.ArticleRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyForm {

    //    http://localhost:8080/article-get?title=제목&content=get
    @GetMapping("/article-get") // 공개 되어도 상관 없는 정보를 전송 할 때 사용
    public String articleGet(@RequestParam String title, @RequestParam String content) {
        String result = "제목: " + title + "\n" + "<br>내용: " + content;
        return result;
    }

    //    http://localhost:8080/article-post
    @PostMapping("/article-post") // 비공개 정보를 전송 할 때 사용
    public String articlePost(@ModelAttribute ArticleRequest request) {
        String result = "제목: " + request.title() + "\n" + "<br>내용: " + request.content();
        return result;
    }

    //    포스트맨 테스트 가능.
    //    {
    //    "title": "postman",
    //    "content": "내용"
    //    }
    //    http://localhost:8080/article-postman
    @PostMapping("/article-postman") // 비공개 정보를 전송 할 때 사용
    public String articlePostman(@RequestBody ArticleRequest request) {
        String result = "제목: " + request.title() + "\n" + "내용: " + request.content();
        return result;
    }

    //    포스트맨 테스트 가능
    //    http://localhost:8080/article-auto
    @PostMapping("/article-auto")
    public String articleAuto(ArticleRequest request) {
        String result = "제목: " + request.title() + "\n" + "내용: " + request.content();
        return result;
    }
}
