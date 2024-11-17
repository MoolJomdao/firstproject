package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.*;

//기본 생성자, Getter, Setter 무조건 추가 해줘야 작동함 시발꺼 책에서 이걸 안가르쳐주네 (2024/11/04 Hwang.Angry

@Data
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
