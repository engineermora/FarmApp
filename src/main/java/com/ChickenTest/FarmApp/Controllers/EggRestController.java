package com.ChickenTest.FarmApp.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ChickenTest.FarmApp.Models.Egg;
import com.ChickenTest.FarmApp.Repositories.EggRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class EggRestController {

	  @Autowired
	    private EggRepository EggRepository;
	  
	    @RequestMapping("/eggs")
	    public List<Object> getEggs(){
	    	return ((Collection<Egg>) EggRepository
	    			.findAll())
	    			.stream()
	    			.map(egg -> eggDTO(egg))
	    			.collect(Collectors.toList());
	    }
	    
	    public Map<String, Object> eggDTO(Egg egg){
	    	Map<String, Object> dto = new LinkedHashMap<>();
	        dto.put("id", egg.getId());
	        dto.put("chickenId", egg.getChicken().getId());
	   
	    	return dto;
	    }
}