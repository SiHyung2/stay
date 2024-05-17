package com.example.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.Criteria;
import com.example.domain.ReviewDTO;

public interface ReviewMapper {

    // Create
    public void insert(ReviewDTO review);
    
    // Read 
    public ReviewDTO select(int rev_num);
    public List<ReviewDTO> selectAll();
    
    // Update
    public int update(ReviewDTO review); 
     
    // Delete 
    public void delete(long rev_Num);
  
    // 수정된 메서드 
    public List<ReviewDTO> getListWithPaging(Criteria cri, long l);

    public ReviewDTO read(Long rev_Num);

	public List<ReviewDTO> getListWithPaging(String cri);

	public List<ReviewDTO> getAllReviews(); 
   
  
	  @Select("select r.rev_num, b.email_id from review r left join booking b on b.bo_num=r.bo_num")
	   public List<ReviewDTO> findAllReviews();

}  
 