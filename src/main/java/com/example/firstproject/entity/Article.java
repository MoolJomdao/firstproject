package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "ARTICLE_SEQ_GENERATOR", sequenceName = "ARTICLE_SEQ", initialValue = 1, allocationSize = 1)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_SEQ_GENERATOR")
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    public void path(Article articleEntity) {
        if(articleEntity.getTitle() != null)
            this.title = articleEntity.getTitle();

        if(articleEntity.getContent() != null)
            this.content = articleEntity.getContent();
    }
}
