package com.ChickenTest.FarmApp.Services.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Repositories.EggRepository;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;
import com.ChickenTest.FarmApp.Services.ChickenServices;

@Service
public class ChickenServiceImplementation implements ChickenServices {

	@Autowired 
	private ChickenRepository chickenRepository;
	
	@Autowired 
	private FarmRepository farmRepository;
	
	@Autowired 
	private EggRepository eggRepository;
	
	@Override
	    public List<Object> getChickenInfo(){
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
	 chickenDTO.setFarmId(newChicken.getFarm().getId());
	 chickenDTO.setJoinDate(newChicken.getJoinDate());
	 chickenDTO.setName(newChicken.getName());
	 chickenDTO.setFarmStatusChicken(newChicken.getStatusInFarm());
	
   	return chickenDTO;
	}
	
	@Override
	public ChickenDTO add(ChickenDTO chickenDTO) {
	Chicken chickenAdd = new Chicken();
	ChickenDTO chickenDTOAdded = new ChickenDTO();
	Farm nowFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
	    	
	chickenAdd.setFarm(nowFarm);
	chickenAdd.setJoinDate(chickenDTO.getJoinDate());
	chickenAdd.setName(chickenDTO.getName());
	chickenAdd.setChickenStatus(chickenDTO.isFarmStatusChicken());
	chickenRepository.save(chickenAdd);
	    	

	nowFarm.addChicken(chickenAdd);
	farmRepository.save(nowFarm);
	    	
	chickenDTOAdded.setId(chickenAdd.getId());
	chickenDTOAdded.setJoinDate(chickenDTO.getJoinDate());
	chickenDTOAdded.setName(chickenDTO.getName());
	chickenDTOAdded.setId(chickenDTO.getId());
	chickenDTOAdded.setFarmStatusChicken(chickenDTO.isFarmStatusChicken());
	
	return chickenDTOAdded;
			
}
	@Override
	public ChickenDTO delete(ChickenDTO chickenDTO) {
	
	Chicken nowChicken = chickenRepository.findById(chickenDTO.getId()).get();
	Farm nowFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
	                
	nowChicken.setStatusInFarm(false);
	nowFarm.delete(nowChicken);

	eggRepository.deleteAll(nowChicken.getEggs());
	chickenRepository.delete(nowChicken);
	farmRepository.save(nowFarm);
	        
	return chickenDTO;
	
	}	 
	
	@Override
	public ChickenDTO update(long farmId, long chickenId, ChickenDTO chickenDTO) {
		
	Chicken chickenUpdate = chickenRepository.findById(chickenDTO.getId()).get();
    ChickenDTO chickenDTOUpdated = new ChickenDTO();
		
   	chickenUpdate.setName(chickenDTO.getName());
   	chickenRepository.save(chickenUpdate);
   	chickenDTOUpdated.setName(chickenDTO.getName());
    	
    	 return chickenDTOUpdated;
	}
}