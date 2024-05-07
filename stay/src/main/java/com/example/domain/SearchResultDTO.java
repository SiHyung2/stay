package com.example.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchResultDTO {

	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date day;
	private int rest_count;
	
}