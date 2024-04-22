package com.example.mapper;

import java.util.List;

import com.example.domain.AccommodationDTO;

public interface AccommodationMapper {
	
	public List<AccommodationDTO> getList();
	public void insertaccommdation(AccommodationDTO accommdation);
	public void updateaccommdation(AccommodationDTO accommdation);
	public void deleteaccommdation(AccommodationDTO accommdation);
	
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommodation);
	public void searchListByTitle(AccommodationDTO accommodation);
	public List<AccommodationDTO> searchByac_type(AccommodationDTO accommdation);
	
}