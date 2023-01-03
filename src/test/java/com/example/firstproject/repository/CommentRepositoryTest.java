package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case1 : 4번 게시글의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            Long articleId = 4L;
            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 수행 결과 예상
            Article article= new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "Park", "Good Will Hunting");
            Comment b = new Comment(2L, article, "Kim", "I AM SAM");
            Comment c = new Comment(3L, article, "Choi", "TENET");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글 출력 검증");
        }
    }
//    /* Case2 : 1번 게시글의 모든 댓글 조회*/
//    {
//        // 입력 데이터 준비
//        Long articleId = 1L;
//        // 실제 수행
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        // 수행 결과 예상
//        List<Comment> expected = Arrays.asList();
//        // 검증
//        assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
//    }
//
//    /* Case 3: 9번 게시글의 모든 댓글 조회 */
//    {
//        // 입력 데이터 준비
//        Long articleId = 9L;
//        // 실제 수행
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        // 수행 결과
//        List<Comment> expected = Arrays.asList();
//        // 검증
//        assertEquals(expected.toString(), comments.toString(), "9번 글은 존재하지않음");
//    }
//
//    /* Case 4: 9999번 게시글의 모든 댓글 조회 */
//    {
//        // 입력 데이터 준비
//        Long articleId = 9999L;
//        // 실제 수행
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        // 수행 결과 예상
//        List<Comment> expected = Arrays.asList();
//        // 검증
//        assertEquals(expected.toString(), comments.toString(), "9999번 글은 존재하지 않음");
//    }
//
//    /* Case 5: -1번 게시글의 모든 댓글 조회 */
//    {
//        // 입력 데이터 준비
//        Long articleId = -1L;
//        // 실제 수행
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        // 수행 결과 예상
//        List<Comment> expected = Arrays.asList();
//        // 검증
//        assertEquals(expected.toString(), comments.toString(), "-1번 글의 모든 댓글 출력 검증");
//    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: 'Park'의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            String nickname = "Park";
            // 실제수행
            List<Comment>comments = commentRepository.findByNickname(nickname);
            // 예상하기
            Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), "Park", "Good Will Hunting");
            Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), "Park", "치킨");
            Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), "Park", "조깅");

            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "'Park'의 모든 댓글 출력");
        }

        /* Case2: "Kim"의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            String nickname = "Kim";
            // 실제수행
            List<Comment>comments = commentRepository.findByNickname(nickname);
            // 예상하기
            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), "Kim", "I AM SAM");
            Comment b = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), "Kim", "샤브샤브");
            Comment c = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), "Kim", "유튜브");

            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "'Kim'의 모든 댓글 출력");
        }
        /* Case3: null의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            String nickname = null;
            // 실제수행
            List<Comment>comments = commentRepository.findByNickname(nickname);
            // 예상하기
            List<Comment> expected = Arrays.asList();
            // 검증
            assertEquals(expected, comments," null의 모든 댓글 출력");
        }
        /* Case4: ""의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            String nickname = "";
            // 실제수행
            List<Comment>comments = commentRepository.findByNickname(nickname);
            // 예상하기
            List<Comment> expected = Arrays.asList();
            // 검증
            assertEquals(expected, comments, "''의 모든 댓글 출력");
        }

        /* Case5: "i"의 모든 댓글 조회*/
        {
            // 입력 데이터 준비
            String nickname = "%i%";
            // 실제수행
            List<Comment>comments = commentRepository.findByNickname(nickname);
            // 예상하기
            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), "Kim", "I AM SAM");
            Comment b = new Comment(3L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), "Choi", "TENET");
            Comment c = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), "Kim", "샤브샤브");
            Comment d = new Comment(6L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), "Choi", "초밥");
            Comment e = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), "Kim", "유튜브");
            Comment f = new Comment(9L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), "Choi", "독서");
            List<Comment> expected = Arrays.asList(a, b, c, d, e, f);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "i가 포함된 이름의 모든 댓글 출력");
        }
    }
}