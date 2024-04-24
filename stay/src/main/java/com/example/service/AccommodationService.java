package com.example.service;

import java.util.List;

import com.example.domain.AccommodationDTO;

public interface AccommodationService {
	
	public List<AccommodationDTO> getList();
	public void insertaccommodation(AccommodationDTO accommdation);
	public void updateaccommodation(AccommodationDTO accommdation);
	public void deleteaccommodation(AccommodationDTO accommdation);
	
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommdation);
	public List<AccommodationDTO> searchListByTitle(AccommodationDTO accommdation);
	public List<AccommodationDTO> searchByac_type(AccommodationDTO accommdation);
	
}
