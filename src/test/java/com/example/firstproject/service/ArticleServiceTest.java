package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅 된다
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");

        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString() , articles.toString());
    }

    @Test
    void show_성공__존재하는_id_입력() {
        // 예상
        Long id = 1l;
        Article expected = new Article(id, "가가가가", "1111");
        // 실제
        Article article = articleService.show(id);
        // 비교
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    void show_실패__존재하지않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;
        // 실제
        Article article = articleService.show(id);
        // 비교
        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void create__성공__title과_content만_있는_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 실제
        Article article = articleService.create(dto);
        // 비교
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    void create__실패__id가_포함된_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;
        // 실제
        Article article = articleService.create(dto);
        // 비교
        assertEquals(expected, article);
    }


    @Test
    @Transactional
    void update__성공____존재하는_id와_title_content가_있는_dto_입력() {
        // 예상
        Long id = 1l;
        String title = "아아아아";
        String content = "8888";

        ArticleForm dto = new ArticleForm(id ,title, content);
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update__성공___존재하는_id와_title_만_있는_dto_입력() {
        // 예상
        Long id = 1l;
        String title = "아아아아";
        String content = "1111";

        ArticleForm dto = new ArticleForm(id ,title, null);
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update__실패___존재하지_않는_id의_dto_입력() {
        // 예상
        Long id = 1l;
        String title = "아아아아";
        String content = "1111";

        ArticleForm dto = new ArticleForm(-1L ,title, content);
        Article expected = null;

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update__실패___id만_있는_dto_입력() {
        // 예상
        Long id = 1l;
        String title = "아아아아";
        String content = "1111";

        ArticleForm dto = new ArticleForm(id ,null, null);
        Article expected = new Article(id, "가가가가", "1111");

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete__성공____존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(1L, "가가가가", "1111");
        // 실제
        Article article = articleService.delete(id);
        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete__실패____존재하지_않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;
        // 실제
        Article article = articleService.delete(id);
        // 비교
        assertEquals(expected, article);
    }
}