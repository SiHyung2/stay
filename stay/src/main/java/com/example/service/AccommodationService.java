package com.example.service;

import java.util.List;
 
import com.example.domain.AccommodationDTO;
import com.example.domain.SearchWordDTO;
import com.example.domain.accommodation_detailDTO;

public interface AccommodationService { 
	 
	public List<AccommodationDTO> getList();
	public void insertaccommodation(AccommodationDTO accommdation);
	public void updateaccommodation(AccommodationDTO accommdation);
	public void deleteaccommodation(AccommodationDTO accommdation);
	 
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommdation);
	public List<AccommodationDTO> searchListByTitle(AccommodationDTO accommdation);
	public List<AccommodationDTO> searchByac_type(AccommodationDTO accommdation);
	public List<SearchWordDTO> aside_search(SearchWordDTO searchword);
	public List<SearchWordDTO> rest_room_search(SearchWordDTO searchword);
	public List<accommodation_detailDTO> accommodation_detail(accommodation_detailDTO accommodation_detail);
}
