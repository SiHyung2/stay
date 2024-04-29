package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.MemberDTO;
import com.example.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j 
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;

	@Override
	public void insert(MemberDTO member) {
		log.info("Inserting member: " + member);
		mapper.insert(member);
	}

	@Override
	public MemberDTO select(String email_id) {
		log.info("Selecting member with email: " + email_id);
		return mapper.select(email_id);
	}
 
	@Override
	public void update(MemberDTO member) {
		log.info("Updating member: " + member);
		mapper.update(member);
	} 

	@Override
	public void delete(String email_id) {
		log.info("Deleting member with email: " + email_id);
		mapper.delete(email_id);
	}

	@Override
	public List<MemberDTO> selectAll() {
		log.info("Selecting all members");
		return mapper.selectAll();
	}
}
