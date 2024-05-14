package com.example.mapper;

import java.util.List;

import com.example.domain.AccommodationDTO;
import com.example.domain.BoByAcDTO;
import com.example.domain.SearchWordDTO;
import com.example.domain.accommodation_detailDTO;

public interface AccommodationMapper {
	
	public List<AccommodationDTO> getList();
	public void insertaccommdation(AccommodationDTO accommdation);
	public void updateaccommdation(AccommodationDTO accommdation);
	public void deleteaccommdation(AccommodationDTO accommdation);
	
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommodation);
	public void searchListByTitle(AccommodationDTO accommodation);
	public List<AccommodationDTO> searchByac_type(AccommodationDTO accommdation);
	public List<SearchWordDTO> aside_search(SearchWordDTO searchword);
	public List<SearchWordDTO> rest_room_search(SearchWordDTO searchword); 
	
	public List<accommodation_detailDTO> accommodation_detail(accommodation_detailDTO accommodation_detail);  //숙소 상세페이지를 출력하기위한 매퍼
	
	// booking에서 ac불러오기위해 작성함
	public List<BoByAcDTO> bookingByaccommodation(String email_id);
}