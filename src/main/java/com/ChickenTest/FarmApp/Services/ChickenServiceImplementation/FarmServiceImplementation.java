package com.ChickenTest.FarmApp.Services.ChickenServiceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ChickenTest.FarmApp.Repositories.FarmRepository;

//import com.ChickenTest.FarmApp.dto.FarmDTO;
//import com.ChickenTest.FarmApp.Models.Farm;
//import com.ChickenTest.FarmApp.Repository.FarmRepository;
import com.ChickenTest.FarmApp.Services.FarmServices;


public class FarmServiceImplementation implements FarmServices {

	@Autowired
	public FarmRepository farmRepository;

	public List<Object> getFarms(){
		//return FarmServiceImplementation;
    /*	return farmRepository
    			.findAll()
    			.stream()
    			.map(farm -> getInfoFarm(farm))
    			.collect(Collectors.toList());
    }
	public FarmDTO getInfoFarm(Farm farm){
    	Farm currentFarm = farmRepository.findById(farm.getId()).get();
    	FarmDTO farmDTO = new FarmDTO();
    	
    	farmDTO.setId(currentFarm.getId());
    	farmDTO.setCreationDate(currentFarm.getCreationDate());
    	//farmDTO.setName(currentFarm.getName());
    	farmDTO.setChickens(currentFarm.getChickens());
    	
    	return farmDTO;
    }*/
	
	
}
}