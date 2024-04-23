package com.example.service;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AccommodationDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
@Log4j
public class AccommodationServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private AccommodationService service;

//	@Test
	public void testGetList() {
        List<AccommodationDTO> list = service.getList();
        list.forEach(Accommodation1 -> log.info(Accommodation1));
    }
	
//  @Test
	public void testInsertAccommodation() {
		AccommodationDTO accommodation=new AccommodationDTO();
  	
	  	Date day1 = new Date(System.currentTimeMillis());  	
	  	Date day2 = new Date(System.currentTimeMillis());
  	
	  	accommodation.setAc_id(4);
	  	accommodation.setEmail_id("testemail");
	  	accommodation.setAc_title("방제1");
	  	accommodation.setAc_type(2);
	  	accommodation.setAc_address("주소1");
	  	accommodation.setAc_info("숙소 소개1");
	  	accommodation.setCheckin(day1);
	  	accommodation.setCheckout(day2);
	  	accommodation.setBu_name("사업자 이름");
		
		
		service.insertaccommdation(accommodation);
		
		log.info(accommodation);
	}

//	@Test
	public void testupdateAccommodation() {
		AccommodationDTO accommodation=new AccommodationDTO();
	
	  	Date day1 = new Date(System.currentTimeMillis());
	  	
	  	Date day2 = new Date(System.currentTimeMillis());
	  	
	  	
	  	
	  	accommodation.setAc_id(2);
	  	accommodation.setEmail_id("testemail");
	  	accommodation.setAc_title("변경된 방제1_서비스");
	  	accommodation.setAc_type(2);
	  	accommodation.setAc_address("변경된주소1_서비스");
	  	accommodation.setAc_info("변경된 숙소 소개1_서비스");
	  	accommodation.setCheckin(day1);
	  	accommodation.setCheckout(day2);
	  	accommodation.setBu_name("사업자 이름");
		
		
		service.updateaccommdation(accommodation);
		
		log.info(accommodation);
	}
	
//	@Test
	public void testdeleteAccommodation() {
		AccommodationDTO accommodation=new AccommodationDTO();
	  	accommodation.setAc_id(4);
		
		
		service.deleteaccommdation(accommodation);
		
		log.info(accommodation);
	}
	
//	@Test
	public void testsearchByac_id() {
		AccommodationDTO accommodation=new AccommodationDTO();
		accommodation.setAc_id(3);
		service.searchByac_id(accommodation);
		
		log.info(accommodation);
		
	}
	
	@Test
	public void testSearchListByTitleAndDateRange() {
		AccommodationDTO accommodation=new AccommodationDTO();
		accommodation.setAc_title("검색 테스트1");
		service.searchListByTitle(accommodation);
		
		log.info(accommodation);
		
	}
	
//	@Test
	public void testsearchByac_type() {
		AccommodationDTO accommodation=new AccommodationDTO();
		accommodation.setAc_type(2);
		service.searchByac_type(accommodation);
		
		log.info(accommodation);
		
	}
}
