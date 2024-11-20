package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //댓글 대표키

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article; //해당 댓글의 부모 게시글

    @Column
    private String nickname; //댓글을 단 사람
    @Column
    private String body; //댓글 본문
}
