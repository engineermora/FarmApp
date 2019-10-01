package com.ChickenTest.FarmApp.Services.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.DTO.EggDTO;
import com.ChickenTest.FarmApp.DTO.FarmDTO;
import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Models.Egg;
import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Repositories.EggRepository;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;
import com.ChickenTest.FarmApp.Services.EggServices;

@Service
public class EggServicesImplementation implements EggServices {
	
	@Autowired
	private EggRepository eggRepository;
	
	@Autowired
	private ChickenRepository chickenRepository;

	@RequestMapping(path = "/egg", method = RequestMethod.GET)
	public List<Object> getData(){
	    	return eggRepository
	    			.findAll()
	    			.stream()
	    			.map(egg -> getEggData(egg))
	    			.collect(Collectors.toList());
	    }
	 
	public EggDTO getEggData(Egg egg){
		Egg nowEgg = eggRepository.findById(egg.getId()).get();	
		EggDTO eggDTO = new EggDTO();
		    	
		eggDTO.setId(nowEgg.getId());
		eggDTO.setChickenId(nowEgg.getChicken().getId());
		eggDTO.setCreationDate(nowEgg.getcreationDate());
			    	
		return eggDTO;
		
		}

	@Override
	public EggDTO add(EggDTO eggDTO) {
    	Egg eggAdded = new Egg();
    	EggDTO eggAddDTO = new EggDTO();
    	Chicken nowChicken = chickenRepository.findById(eggDTO.getChickenId()).get();

    	eggAdded.setChicken(nowChicken);
    	eggAdded.setCreationDate(eggDTO.getCreationDate());
    	eggRepository.save(eggAdded);
    	nowChicken.addEgg(eggAdded); // Aca agrego el egg al chicken
    	chickenRepository.save(nowChicken);
    
    	eggAddDTO.setId(eggAdded.getId());
    	eggAddDTO.setCreationDate(eggDTO.getCreationDate());
    	eggAddDTO.setChickenId(eggDTO.getChickenId());
		
		return eggAddDTO;
						
	}

	@Override
	public EggDTO delete(EggDTO eggDTO) {

		Egg nowEgg = eggRepository.findById(eggDTO.getId()).get();
        Chicken nowChicken = chickenRepository.findById(eggDTO.getChickenId()).get();
        nowChicken.deleteEgg(nowEgg);
        eggRepository.deleteById(eggDTO.getId());
	       	       
		return eggDTO;
	}
	
}