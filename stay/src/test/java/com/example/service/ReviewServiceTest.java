//package com.example.service;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.config.RootConfig;
//import com.example.domain.ReviewDTO;
//
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { RootConfig.class })
//@Log4j
//public class ReviewServiceTest { 
// 
//	@Autowired
//	private ReviewService service;
// 
// @Test 
//	public void testinsert() {
//		ReviewDTO newReview = new ReviewDTO();
//		newReview.setRev_Num(3); // Set the rev_Num (assuming it's auto-generated)
//		newReview.setBo_Num("123456"); // Set the bo_Num
//		newReview.setAc_Title("Sample Article Title"); // Set the ac_Title
//		newReview.setRoom_Num(1); // Set the room_Num
//		newReview.setContent("This is a new review."); // Set the content
//		newReview.setReview_Date(new Date()); // Set the review_Date (current date)
//		newReview.setUpdate_Date(new Date()); // Set the update_Date (current date)
//
//		service.insert(newReview); 
//	} 
//
////@Test
//	public void testRead() {
//	    Long rev_Num = 1L; // Change to Long
//	    ReviewDTO dto = service.select(rev_Num);
//	    log.info(dto);
//	  
//	}  
// 
////	@Test
//	public void testDelete() {
//		Long rev_Num = 1L;
//		service.delete(rev_Num);
//	} 
//
//    
////	@Test
//	public void testUpdate() {
//		Long rev_Num = 2L;
//		ReviewDTO dto = service.select(rev_Num);
//		dto.setContent("Update Reply ");
//		service.update(dto);
//	}
//
////		@Test
//	public void testList() {
//		List<ReviewDTO> reviews = service.selectAll();
//		reviews.forEach(review -> log.info(review));
//	}
//}