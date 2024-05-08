package com.example.domain;

import org.springframework.stereotype.Component;

import com.example.mapper.MemberMapper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter 
@Setter 
@Component
public class LoginVO {
	


    private String email_id;
    private String password;
    private String type_code;
    
 
	
}






  

 