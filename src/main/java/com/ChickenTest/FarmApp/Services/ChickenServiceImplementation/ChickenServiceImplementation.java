package com.ChickenTest.FarmApp.Services.ChickenServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;
import com.ChickenTest.FarmApp.Services.ChickenServices;

public class ChickenServiceImplementation implements ChickenServices {

	@Autowired 
	private ChickenRepository chickenRepository;
	
	
	@Override
	public List<Object> getChickens() {
		return chickenRepository
				.findAll()
				.stream()
				.map(chicken -> getChickenData(chicken))
				.collect(Collectors.toList());
	}

	 @Override
	    public ChickenDTO getChickenData(Chicken chicken){
	    	Chicken newChicken = chickenRepository.findById(chicken.getId()).get();
	    	ChickenDTO chickenDTO = new ChickenDTO();
	    	
	    	chickenDTO.setId(newChicken.getId());
	    	chickenDTO.setId(newChicken.getFarm().getId());
	    	chickenDTO.setJoinDate(newChicken.getJoinDate());
	    	//chickenDTO.setName(newChicken.getName());
	    	
	    	return chickenDTO;
	    }
	

	@Override
	public ChickenDTO add(ChickenDTO chickenDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChickenDTO delete(ChickenDTO chickenDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChickenDTO update(ChickenDTO chickenDTO) {
		Chicken chickenToEdit = chickenRepository.findById(chickenDTO.getId()).get();
    	ChickenDTO chickenDTOEdited = new ChickenDTO();
      //  Farm nowFarm = FarmRepository.findById(chickenDTO.getId()).get();
	}
	
	// Tiene la logica de lo que el metodo debe realizar.
	
	
	
}