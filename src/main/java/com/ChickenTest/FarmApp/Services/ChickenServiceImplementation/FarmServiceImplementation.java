package com.ChickenTest.FarmApp.Services.ChickenServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ChickenTest.FarmApp.DTO.FarmDTO;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;

//import com.ChickenTest.FarmApp.dto.FarmDTO;
//import com.ChickenTest.FarmApp.Models.Farm;
//import com.ChickenTest.FarmApp.Repository.FarmRepository;
import com.ChickenTest.FarmApp.Services.FarmServices;


public class FarmServiceImplementation implements FarmServices {

/////////////////
	
	 public List<Object> getFarms(){
	    	return FarmRepository
	    			.findAll()
	    			.stream()
	    			.map(farm -> getFarmData(farm))
	    			.collect(Collectors.toList());
	    }
	    
	    public FarmDTO getFarmData(Farm farm){
	    	Farm currentFarm = FarmRepository.find(farm.getId()).get();
	    	FarmDTO farmDTO = new FarmDTO();
	    	
	    	farmDTO.setId(currentFarm.getId());
	    	farmDTO.setCreationDate(currentFarm.getCreationDate());
	    	farmDTO.setName(currentFarm.getName());
	    	farmDTO.setChickens(currentFarm.getChickens());
	    	
	    	return farmDTO;
	    }
	}
	
	
	
	
	
	//////////////////////////////

@Override
public FarmDTO getChickenData(FarmDTO farm) {
	// TODO Auto-generated method stub
	return null;
}


	@Override
	public FarmDTO add(FarmDTO farm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FarmDTO delete(FarmDTO farm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FarmDTO update(FarmDTO farm) {
		// TODO Auto-generated method stub
		return null;
	}

	
}