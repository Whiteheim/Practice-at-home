package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 인식 가능 (해당 Class를 Table로 만든다)
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 데이터를 자동 생성 sequence
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article){
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }


}
