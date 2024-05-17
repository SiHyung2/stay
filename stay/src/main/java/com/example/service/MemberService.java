package com.example.service;

import java.util.List;

import com.example.domain.LoginVO;
import com.example.domain.MemberDTO;

public interface MemberService {
  

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
   