package com.ChickenTest.FarmApp.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ChickenTest.FarmApp.DTO.FarmDTO;
import com.ChickenTest.FarmApp.Services.FarmServices;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.ChickenTest.FarmApp.Services"})
public class FarmRestController {

	    
		@Autowired
	    private FarmServices farmServices;
	    
			@CrossOrigin(origins = "http://localhost:4200")
			@RequestMapping(path = "/farm", method = RequestMethod.GET)
			public List<Object> getFarms() {
	        	return farmServices.getFarms();
		    }

		    @CrossOrigin(origins = "http://localhost:4200")
		    @RequestMapping(path ="/add_farm", method = RequestMethod.POST)
		    public FarmDTO addFarm(@RequestBody FarmDTO farmDTO){
		    	FarmDTO farmDTOAdded = farmServices.add(farmDTO);
		    	return farmDTOAdded;
		    }
		   
		    @CrossOrigin(origins = "http://localhost:4200")
		    @RequestMapping(path ="/delete_farm", method = RequestMethod.POST)
		    public FarmDTO deleteFarm(@RequestBody FarmDTO farmDTO){
		    	FarmDTO farmDTODelete = farmServices.delete(farmDTO);
		    	return farmDTODelete;
		    }
	    
	    }
