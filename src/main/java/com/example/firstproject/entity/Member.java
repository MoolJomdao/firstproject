package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "MEMEBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMEBER_SEQ_GENERATOR")
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
