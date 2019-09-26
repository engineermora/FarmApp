package com.ChickenTest.FarmApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ChickenTest.FarmApp.DTO.FarmDTO;

@Service
public interface FarmServices {

		public List<Object> getFarms();
		
		public FarmDTO getChickenData(FarmDTO farm);
		
		public FarmDTO add(FarmDTO farm);
		
		public FarmDTO delete(FarmDTO farm);
		
		public FarmDTO update(FarmDTO farm);
		
}