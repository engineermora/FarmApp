package com.ChickenTest.FarmApp.Controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class ChickenRestController {

	@Autowired
    private ChickenRepository chickenRepository;
	
	 @RequestMapping("/chickens")
	    public List<Object> getChickens(){
	    	return ((Collection<Chicken>) chickenRepository
	    			.findAll())
	    			.stream()
	    			.map(chicken -> chickenDTO(chicken))
	    			.collect(Collectors.toList());
	    }
	    
	    public Map<String, Object> chickenDTO(Chicken chicken){
	    	Map<String, Object> dto = new LinkedHashMap<>();
	        dto.put("id", chicken.getId());
	        dto.put("farmId", chicken.getFarm().getId());
	        dto.put("eggsAmount", chicken.getEggsAmount());
	   
	    	return dto;
	    }
}
