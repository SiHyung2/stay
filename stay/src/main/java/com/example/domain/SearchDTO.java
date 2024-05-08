package com.example.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchDTO {

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkin;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkout;
	private String bu_name;
	
	private String search_word;
//	카테고리 입력은 체크박스이므로 배열로 되어야한다.
	private int ac_id;  
	private int ro_basic_count;
	
}