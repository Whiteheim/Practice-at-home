package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 생성해놓은 객체를 가져다가 자동으로 연결해줌
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticles(ArticleForm form){
        System.out.println(form.toString());

        // 1. dto 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. repository를 통해 db에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}