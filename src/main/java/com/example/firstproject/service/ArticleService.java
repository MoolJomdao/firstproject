package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private static ArticleRepository articleRepository;

    public ArrayList<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm form) {
        Article article = form.toEntity();

        if(article.getId() != null){
            return null;
        }

        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm form) {
        //1. DTO -> Entity 변환하기
        Article articleEntity = form.toEntity();
        log.info("ID: {}, Article: {}", id, articleEntity.toString());

        //2. Target 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리하기
        if(target == null || id != articleEntity.getId()){
            //400, 잘못된 요청 응답
            return null;
        }

        //4. 업데이트 및 정상 응답(200)
        target.path(articleEntity);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public static Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null){
            return null;
        }

        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public ArrayList<Article> createArticles(ArrayList<ArticleForm> dtos) {
        //1. DTO 묶음을 엔티티 묶음으로 변환하기
        ArrayList<Article> articleList = (ArrayList<Article>) dtos.stream().map(dto->dto.toEntity()).collect(Collectors.toList());

        //2. 엔티티 묶음을 DB에 저장하기
        articleList.stream().forEach(article -> articleRepository.save(article));

        //3. 강제 예외 발생시키기
        articleRepository.findById(-1L).orElseThrow(()-> new IllegalArgumentException("결재 실패!"));

        //4. 결과 값 반환하기
        return articleList;
    }
}
