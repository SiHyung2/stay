package com.example.mapper;

import java.util.List;

import com.example.domain.LoginVO;
import com.example.domain.MemberDTO;

public interface MemberMapper {

    // Create
    public void insert(MemberDTO member);
    
    // Read
    public MemberDTO select(String email_id);
    public List<MemberDTO> selectAll();
    
    // Update
    public void update(MemberDTO member);
    
    // Delete
    public void delete(String email_id);

	public LoginVO validateMember(LoginVO member);
    
	
} 
 
	/*
	 * // Create (회원가입) int memberJoin(MemberDTO member);
	 * 
	 * // Read (이메일 중복 확인) int idCheck(String email);
	 * 
	 * // Read (회원 로그인) MemberDTO memberLogin(String email, String password);
	 */

 
 