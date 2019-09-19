package com.ChickenTest.FarmApp.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.ChickenTest.FarmApp.Models.Chicken;

@Service
public class FarmServices {

		public List<Chicken> list =new ArrayList<>();
	
		public void FarmService() {
			
		System.out.println("Services Layer is created");
		list.add(new Chicken());
		
		}
	
	
}
