package com.ChickenTest.FarmApp.Controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ChickenTest.FarmApp.Models.Chicken;
import com.ChickenTest.FarmApp.Repositories.ChickenRepository;
import com.ChickenTest.FarmApp.Services.FarmServices;


@RestController
@RequestMapping("/api")
public class ChickenRestController {

	@SuppressWarnings("unused")
	@Autowired
    private ChickenRepository chickenRepository;
	
	 @RequestMapping("/chickens")
	  public List<Object> getFarm(){
	    	return FarmServices.getFarms();  
	 
	 /* */
	    }
}
