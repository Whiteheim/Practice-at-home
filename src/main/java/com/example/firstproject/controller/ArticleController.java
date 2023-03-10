package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // 로깅을 위한 annotation
public class ArticleController {

    @Autowired // 스프링 부트가 생성해놓은 객체를 가져다가 자동으로 연결해줌
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticles(ArticleForm form){
        log.info(form.toString());
//        System.out.println(form.toString()); -> logging 기능으로 대체

        // 1. dto -> Entity 변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());

        // 2. repository를 통해 Entity를 db에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1. id로 데이터로 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List< CommentDto> commentDtos = commentService.comments(id);

        // 값이 없으면 null반환

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentDtos);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 Article을 가져옴
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 View로 전달
        model.addAttribute("articleList", articleEntityList);
        // 3. View 페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit") // {id}와 Parameter의 id가 이름이 동일해야 함
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // Model에 데이터 등록
        model.addAttribute("article", articleEntity);

        // View 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());

        // 1. DTO 를 Entity로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2. Entity를 DB에 저장
        // 2-1 DB에서 기존 데이터를 가져옴
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2 기존 데이터의 값을 수정/갱신
        if (target != null) {
            articleRepository.save(articleEntity); // Entity가 DB로 갱신
        }

        // 3. 수정 결과 페이지로 Redirect

        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제요청");

        // 1. 삭제 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        // 2. 대상 삭제
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
        }

        // 3. 결과 페이지로 redirect
        return "redirect:/articles";
    }
}

