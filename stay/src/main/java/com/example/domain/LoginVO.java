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
	
//	private MemberMapper memberMapper;
//	
//	
//	
//	    public LoginVO(MemberMapper memberMapper) {
//	        this.memberMapper = memberMapper;
//	    }

    private String email_id;
    private String password;
    private String type_code;
    
    
    

//    public MemberDTO validateMember(String email_id, String password) {
//        return memberMapper.validateMember(email_id, password);
//    }
    
	
}






  

 