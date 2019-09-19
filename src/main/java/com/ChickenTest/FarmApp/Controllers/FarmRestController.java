package com.ChickenTest.FarmApp.Controllers;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class FarmRestController {

	    @Autowired
	    private FarmRepository farmRepository;
	    
	    @RequestMapping("/farm")
	    public List<Object> getFarm(){
	    	return ((Collection<Farm>) farmRepository
	    			.findAll())
	    			.stream()
	    			.map(farm -> farmDTO(farm))
	    			.collect(Collectors.toList());
	    }
	    
	    public Map<String, Object> farmDTO(Farm farm){
	    	Map<String, Object> dto = new LinkedHashMap<>();
	        dto.put("id", farm.getId());
	        dto.put("chickensAmount", farm.getChickensAmount());
	        dto.put("eggsAmountTotal", farm.getEggsAmountTotal());
	   //   dto.put("chickens", farm.getChickens().stream().map(chicken -> chickenDTO(chicken)));
	   //     dto.put("eggs", farm.getChickens().stream().map(chicken -> chicken.getEggs().stream().map(egg -> eggDTO(egg))));
	   
	    	return dto;
	    }
	    
}
