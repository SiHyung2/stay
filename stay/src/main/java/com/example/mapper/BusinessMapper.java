package com.example.mapper;

import java.util.List;

import com.example.domain.BusinessDTO;

public interface BusinessMapper {
													//한 사람의 숙소가 여러개일 수도 있으니 List 로 출력한다
	public List<BusinessDTO> search_by_email_id(String email_id);    // 세션인 이메일 아이디로 숙소 정보를 불러오는 매퍼

	
}