package com.example.service;

import java.util.List;

import com.example.domain.BusinessDTO;

public interface BusinessService {
	 
	public List<BusinessDTO> search_by_email_id(String email_id);
}
