package com.example.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AccommodationDTO;
import com.example.domain.SearchWordDTO;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
@Log4j2
public class AccommodationMapperTest {
    
	@Autowired
	private AccommodationMapper mapper;

//	@Test
	public void testGetList() {
	    List<AccommodationDTO> list = mapper.getList();
	    list.forEach(accommodation -> log.info(accommodation));
	}
    
//    @Test
  	public void testInsertAccommodation() {
    	AccommodationDTO accommodation=new AccommodationDTO();
    	
    	Date day1 = new Date(System.currentTimeMillis());
    	
    	Date day2 = new Date(System.currentTimeMillis());
    	
    	
    	
    	accommodation.setAc_id("1");
    	accommodation.setEmail_id("testemail");
    	accommodation.setAc_title("방제1");
    	accommodation.setAc_type(2);
    	accommodation.setAc_address("주소1");
    	accommodation.setAc_info("숙소 소개1");
    	accommodation.setCheckin(day1);
    	accommodation.setCheckout(day2);
    	accommodation.setBu_name("사업자 이름");
		
		
		mapper.insertaccommdation(accommodation);
		
		log.info(accommodation);
	}
 
//    @Test
	public void testupdateAccommodation() {
		AccommodationDTO accommodation=new AccommodationDTO();
  	
	  	Date day1 = new Date(System.currentTimeMillis());
	  	
	  	Date day2 = new Date(System.currentTimeMillis());
	  	
	  	
	  	
	  	accommodation.setAc_id("2");
	  	accommodation.setEmail_id("testemail");
	  	accommodation.setAc_title("변경된 방제33");
	  	accommodation.setAc_type(2);
	  	accommodation.setAc_address("변경된주소1");
	  	accommodation.setAc_info("변경된 숙소 소개1");
	  	accommodation.setCheckin(day1);
	  	accommodation.setCheckout(day2);
	  	accommodation.setBu_name("사업자 이름");
		
		
		mapper.updateaccommdation(accommodation);
		
		log.info(accommodation);
	}
	
//	@Test
	public void testdeleteAccommodation() {
		AccommodationDTO accommodation=new AccommodationDTO();
	  	accommodation.setAc_id("2");
		
		
		mapper.deleteaccommdation(accommodation);
		
		log.info(accommodation);
	}
	
//	@Test
	public void testsearchByac_id() {
		AccommodationDTO accommodation=new AccommodationDTO();
		accommodation.setAc_id("2");
		mapper.searchByac_id(accommodation);
		
		log.info(accommodation);
	}

	
//	@Test  
	public void testSearchListByTitleAndDateRange() {
		AccommodationDTO accommodation=new AccommodationDTO();
		accommodation.setAc_title("0");
		mapper.searchListByTitle(accommodation);
		
		log.info(accommodation);
		
	}
	

	@Test
	public void aside_search() {
		SearchWordDTO searchword=new SearchWordDTO();
		searchword.setAc_title("");
		searchword.setRo_basic_count(0);
		searchword.setAc_type_checkbox1(0);
		searchword.setAc_type_checkbox2(1);
		searchword.setAc_type_checkbox3(0);
		searchword.setAc_type_checkbox4(0);
		searchword.setAc_type_checkbox5(0);
		searchword.setAc_type_checkbox6(0);
		searchword.setAc_type_checkbox7(0);
		List<SearchWordDTO> resultList = mapper.aside_search(searchword);
		
	}
	
	
//	@Test
	public void rest_room_searchTest() {
		SearchWordDTO searchword=new SearchWordDTO();
		searchword.setAc_title("");
		searchword.setAc_type(1);
//		searchword.setCheckout(new Date());

	    List<SearchWordDTO> resultList = mapper.rest_room_search(searchword);

	}


}