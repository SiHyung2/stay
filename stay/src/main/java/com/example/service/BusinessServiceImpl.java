package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.BusinessDTO;
import com.example.mapper.BusinessMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessServiceImpl implements BusinessService{
	
	private BusinessMapper mapper;
	
	@Override
	public List<BusinessDTO> search_by_email_id(String email_id) {
		return mapper.search_by_email_id(email_id);
	}

}
