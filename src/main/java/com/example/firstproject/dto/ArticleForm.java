package com.example.firstproject.dto;

import java.beans.ConstructorProperties;

//기본 생성자, Getter, Setter 무조건 추가 해줘야 작동함 시발꺼 책에서 이걸 안가르쳐주네 (2024/11/04 Hwang.Angry

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(){}

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


}
