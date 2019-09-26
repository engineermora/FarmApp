package com.ChickenTest.FarmApp.Controllers;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ChickenTest.FarmApp.Models.Farm;
import com.ChickenTest.FarmApp.Repositories.FarmRepository;
import com.ChickenTest.FarmApp.Services.FarmServices;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.ChickenTest.FarmApp.Services"})
public class FarmRestController {

	    
		@Autowired
	    private FarmServices farmServices;
	    
	    @RequestMapping(path = "/farm", method = RequestMethod.GET)
		public List<Object> getFarms() {
	    return farmServices.getFarms();
	    
	  /*  public Map<String, Object> farmDTO(Farm farm){
	    	Map<String, Object> dto = new LinkedHashMap<>();
	        dto.put("id", farm.getId());
	        dto.put("chickensAmount", farm.getChickensAmount());
	        dto.put("eggsAmountTotal", farm.getEggsAmountTotal());
	   //   dto.put("chickens", farm.getChickens().stream().map(chicken -> chickenDTO(chicken)));
	   //   dto.put("eggs", farm.getChickens().stream().map(chicken -> chicken.getEggs().stream().map(egg -> eggDTO(egg))));
	   
	    	return dto;
	    } */
	    
}
}
