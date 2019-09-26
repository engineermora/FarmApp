package com.ChickenTest.FarmApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.Models.Chicken;

@Service
public interface ChickenServices {
	
	public List<Object> getChickens();
	
	public ChickenDTO getChickenData(Chicken chicken);
	
	public ChickenDTO add(ChickenDTO chickenDTO);
	
	public ChickenDTO delete(ChickenDTO chickenDTO);
	
	public ChickenDTO update(ChickenDTO chickenDTO);

	
}