package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.Data;

@Data
public class MemberForm {
    private String Member_Email;
    private String Member_Password;

    public Member toEntity(){
        return new Member(null, this.Member_Email, this.Member_Password);
    }
}
