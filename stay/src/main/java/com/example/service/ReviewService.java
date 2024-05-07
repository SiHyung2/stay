package com.example.service;

import com.example.domain.Criteria;

import com.example.domain.ReviewDTO;

import java.util.List;

public interface ReviewService {

    // 리뷰 생성
	public void insert(ReviewDTO review);
	// Read  
	public ReviewDTO select(Long rev_Num);
	
	public List<ReviewDTO> selectAll();

	// Update
	public void update(ReviewDTO review);
	  
	// Delete
	public boolean delete(Long rev_Num);

	// 수정된 메서드
	public List<ReviewDTO> getListWithPaging(Criteria cri, long l);

	public ReviewDTO read(Long rev_Num);
	List<ReviewDTO> selectAll(Criteria cri); 
	
	
	List<ReviewDTO> getAllReviews(); 
	public int getTotal(Criteria cri);
	public Object getList(Criteria cri);
	public Object getPageDTO(Criteria cri, int total);

	    
	 
	} 


