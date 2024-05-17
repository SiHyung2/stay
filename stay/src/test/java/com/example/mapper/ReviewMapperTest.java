package com.example.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.RootConfig;
import com.example.domain.Criteria;
import com.example.domain.ReviewDTO;

import lombok.extern.log4j.Log4j2;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j2
public class ReviewMapperTest {

	@Autowired
	private ReviewMapper mapper;

//@Test
	public void testCreate() {
		ReviewDTO newReview = new ReviewDTO();
		newReview.setRev_Num(2); // Set the rev_Num (assuming it's auto-generated)
		newReview.setBo_Num("123456"); // Set the bo_Num
		newReview.setAc_Title("Sample Article Title"); // Set the ac_Title
		newReview.setRoom_Num(1); // Set the room_Num
		newReview.setContent("This is a new review."); // Set the content
		newReview.setReview_Date(new Date()); // Set the review_Date (current date)
		newReview.setUpdate_Date(new Date()); // Set the update_Date (current date)

		mapper.insert(newReview); 
	} 
 
//@Test
	public void testRead() {
	    Long rev_Num = 1L; // Change to Lon g
	    ReviewDTO dto = mapper.read(rev_Num);
	    log.info(dto);
	 
	} 
 
//	@Test
	public void testDelete() {
		Long rev_Num = 1L;
		mapper.delete(rev_Num);
	}

//   
//	@Test 
	public void testUpdate() {
		Long rev_Num = 1L;
		ReviewDTO dto = mapper.read(rev_Num);
		dto.setContent("Update Reply ");
		int count = mapper.update(dto);
		log.info("UPDATE COUNT: " + count);
	}

//	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReviewDTO> reviews = mapper.getListWithPaging(cri, 1L);
		reviews.forEach(review -> log.info(review));
	}
	
	@Test
	public void testFindAllReviews() {
	    List<ReviewDTO> reviews = mapper.findAllReviews();

	    // Assert that at least one review is retrieved
	    assertFalse(reviews.isEmpty());

	    // Loop through reviews and verify data (optional, based on your needs)
	    for (ReviewDTO review : reviews) {
	        // Assert specific values for revNum, emailId, etc.
	        assertTrue(review.getRev_Num() > 0); // Assuming revNum is positive
	        assertNotNull(review.getEmail_Id()); // Check for non-empty emailId
	        
	        // Add more assertions for other ReviewDTO fields if applicable
	    }
	}


}
