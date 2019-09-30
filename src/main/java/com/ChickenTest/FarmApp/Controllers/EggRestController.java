package com.ChickenTest.FarmApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ChickenTest.FarmApp.DTO.EggDTO;
import com.ChickenTest.FarmApp.Services.EggServices;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.ChickenTest.FarmApp.Services"})
public class EggRestController {


	    @Autowired
	    private EggServices eggServices;

	    @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(path = "/eggs", method = RequestMethod.GET)
	    public List<Object> getEggs(){
	    	return eggServices.getData();
	    }

	    @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(path ="/add_egg", method = RequestMethod.POST)
	    public EggDTO addEgg(@RequestBody EggDTO eggDTO){
	    	EggDTO eggDTOAdded = eggServices.add(eggDTO);
	    	return eggDTOAdded;
	    }
	   
	    @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(path ="/delete_egg", method = RequestMethod.POST)
	    public EggDTO deleteEgg(@RequestBody EggDTO eggDTO){
	    	EggDTO eggDTODelete = eggServices.delete(eggDTO);
	    	return eggDTODelete;
	    }
}