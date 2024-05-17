package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Criteria;
import com.example.domain.LoginVO;
import com.example.domain.ReviewDTO;
import com.example.mapper.ReviewMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
 
@Service 
@Log4j   
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	//@Setter(onMethod_ = @Autowired) ��� -> @AllArgsConstructor 
	private ReviewMapper mapper;
	
	  
	
	@Override
	public void insert(ReviewDTO review) {
		
		log.info("insert......" + review);
		mapper.insert(review);  
	
		// TODO Auto-generated method stub
		 
	} 
 
	@Override 
	public ReviewDTO select(Long rev_Num) {
		log.info("select........"+rev_Num);
		return mapper.read(rev_Num);
	}  

	@Override
	public List<ReviewDTO> selectAll(Criteria cri) { 
	    log.info("get List with criteria: " + cri);
	    return mapper.getListWithPaging(cri, 0);
	    // TODO: 전체 리뷰 조회 기능 구현 
	} 

  
	
  
	@Override
	public void update(ReviewDTO review) {
	    log.info("update...." + review);
	    mapper.update(review);
	}

	

	@Override
	public boolean delete(Long rev_Num) {
	    log.info("delete...." + rev_Num);
	    mapper.delete(rev_Num);
	    // 삭제된 행의 수가 1이면 성공한 것으로 간주
	    return true;
  
	}

	@Override
	public List<ReviewDTO> getListWithPaging(Criteria cri, long l) {
		// TODO: 페이지별 리뷰 목록 조회 기능 구현
		return null;
	}
  
	@Override
	public ReviewDTO read(Long rev_Num) {
		// TODO: 리뷰 상세 조회 기능 구현
		return null;
	}

	@Override
	public List<ReviewDTO> selectAll() {
	    log.info("get all reviews");
	    return mapper.getAllReviews();
	}

	@Override
	public List<ReviewDTO> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPageDTO(Criteria cri, int total ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewDTO> selectBusiness_Reviews() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public LoginVO validateMember(LoginVO member) {
//		// TODO Auto-generated method stub 
//		return null;
//	}
} 
 

