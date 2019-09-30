package com.ChickenTest.FarmApp.Services;

import java.util.List;

import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.Models.Chicken;

public interface ChickenServices {
	
	public List<Object> getChickenInfo();
	
	public ChickenDTO getChickenData(Chicken chicken);
	
	public ChickenDTO add(ChickenDTO chickenDTO);
	
	public ChickenDTO delete(ChickenDTO chickenDTO);
	
	public ChickenDTO update(long farmId, long chickenId, ChickenDTO chickenDTO);

	
}