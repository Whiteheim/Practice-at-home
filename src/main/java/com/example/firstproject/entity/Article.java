package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 인식 가능
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 추가
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue // sequence
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

}
