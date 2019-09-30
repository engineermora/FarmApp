package com.ChickenTest.FarmApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ChickenTest.FarmApp.DTO.ChickenDTO;
import com.ChickenTest.FarmApp.Services.ChickenServices;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.ChickenTest.FarmApp.Services"})
public class ChickenRestController {
	
	  @Autowired
	  private ChickenServices chickenServices;

      @CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(path = "/chicken", method = RequestMethod.GET)
	  public List<Object> getChicken(){
	   
    	  return chickenServices.getChickenInfo();
	  }
	    
	    // Ruta para agregar Chickens
	  	
	   @CrossOrigin(origins = "http://localhost:4200")
	   @RequestMapping(path ="/add_chicken", method = RequestMethod.POST)
	   public ChickenDTO chickenAdd(@RequestBody ChickenDTO chickenDTO){
	   
		   ChickenDTO chickenDTOAdded = chickenServices.add(chickenDTO);
	    
		   return chickenDTOAdded; 
	    }
	    
	    // Ruta para editar Chickens
	  	
	    @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(path ="{farm_id}/update_chicken/{chicken_id}", method = RequestMethod.POST)
	    public ChickenDTO updateChicken(@PathVariable ("farm_id") long farmId, @PathVariable ("chicken_id") long chickenId, @RequestBody ChickenDTO chickenDTO){
	   	ChickenDTO chickenDTOUpdated = chickenServices.update(farmId, chickenId, chickenDTO);
	    
	   	return chickenDTOUpdated;
	    }
	    
	    // Rutas para eliminar Chickens.
	  	//@CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(path ="/delete_chicken", method = RequestMethod.POST)
	    public ChickenDTO deleteChicken(@RequestBody ChickenDTO chickenDTO){
	    ChickenDTO chickenDeleteDTO = chickenServices.delete(chickenDTO);
	    
	    return chickenDeleteDTO;
	    
	    }
}