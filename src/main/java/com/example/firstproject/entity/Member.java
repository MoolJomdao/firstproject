package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Member_Email;
    @Column
    private String Member_Password;

    public Member(Long id, String member_Email, String member_Password) {
        this.id = id;
        this.Member_Email = member_Email;
        this.Member_Password = member_Password;
    }
}
