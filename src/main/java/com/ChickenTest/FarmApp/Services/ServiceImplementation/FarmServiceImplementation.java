package com.ChickenTest.FarmApp.Services.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChickenTest.FarmApp.DTO.FarmDTO;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Repositories.EggRepository;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;

import com.ChickenTest.FarmApp.Services.FarmServices;

@Service
public class FarmServiceImplementation implements FarmServices {

	@Autowired
    private FarmRepository farmRepository;

	@Autowired
    private ChickenRepository chickenRepository;

	@Autowired
    private EggRepository eggRepository;
	
	public List<Object> getFarms() {
		return farmRepository
					.findAll()
					.stream()
					.map(farm -> getFarmData(farm))
					.collect(Collectors.toList());
    }
    
        	
    	public FarmDTO getFarmData(Farm farm){
        	Farm nowFarm = farmRepository.findById(farm.getId()).get();
        	FarmDTO farmDTO = new FarmDTO();
        	
        	farmDTO.setId(nowFarm.getId());
        	farmDTO.setCreationDate(nowFarm.getCreationDate());
        	farmDTO.setFarmName(nowFarm.getName());
        	//farmDTO.setChickens(nowFarm.getChickens());
        	farmDTO.setChickensAmount(nowFarm.getChickensAmount());
        	farmDTO.setEggsAmount(nowFarm.getEggsAmountTotal());
        	
        	return farmDTO;
        }
    // Agregar Granja
    @Override
		public FarmDTO add(FarmDTO farmDTO) {
		Farm farmAdd = new Farm();
    	FarmDTO farmAddDTO = new FarmDTO();
    	
    	farmAdd.setName(farmDTO.getFarmName());
        farmAdd.setCreationDate(farmDTO.getCreationDate());
        farmRepository.save(farmAdd);
    	
     	farmAddDTO.setId(farmAdd.getId());
    	farmAddDTO.setCreationDate(farmDTO.getCreationDate());
    	farmAddDTO.setFarmName(farmDTO.getFarmName());
		
		return farmAddDTO;
	}
// Eliminar granja
	@Override
		public FarmDTO delete(FarmDTO farmDTO) {
        Farm nowFarm = farmRepository.findById(farmDTO.getId()).get();
       
        nowFarm.getChickens().forEach(chicken -> eggRepository.deleteAll(chicken.getEggs()));
        chickenRepository.deleteAll(nowFarm.getChickens());
        farmRepository.delete(nowFarm);
        
		return farmDTO;
	}
// opcion nacer a los huevos 

	@Override
	public FarmDTO update(long farmId, FarmDTO farmDTO) {
		Farm farmUpdate = farmRepository.findById(farmId).get();
    	FarmDTO farmUpdateDTO = new FarmDTO();
        
    	farmUpdate.setName(farmDTO.getFarmName());
    	farmRepository.save(farmUpdate);
    	
    	farmUpdateDTO.setFarmName(farmDTO.getFarmName());
    	
		return farmUpdateDTO;
	}
}