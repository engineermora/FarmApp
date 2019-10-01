package com.ChickenTest.FarmApp.Services;

import java.util.List;

import com.ChickenTest.FarmApp.DTO.FarmDTO;
import com.ChickenTest.FarmApp.Models.Farm;


public interface FarmServices {

		public List<Object> getFarms();
		
		public FarmDTO getFarmData(Farm farm);
		
		public FarmDTO add(FarmDTO farm);
		
		public FarmDTO delete(FarmDTO farm);
		
		public FarmDTO update(long farmId, FarmDTO farmDTO);
		
}