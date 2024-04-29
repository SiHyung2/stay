package com.example.mapper;


import java.util.List;
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
    public void delete(Long rev_Num);
  
    // 수정된 메서드
    public List<ReviewDTO> getListWithPaging(Criteria cri, long l);

    public ReviewDTO read(Long rev_Num);

	public List<ReviewDTO> getListWithPaging(String cri);

	public List<ReviewDTO> getAllReviews(); 
  
     
     
} 
 